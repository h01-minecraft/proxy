package com.hariharnautiyal.velocity.h01.managers

import com.hariharnautiyal.velocity.h01.models.*
import kotlinx.serialization.json.Json
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID

class SessionManager (
    private val redisManager: RedisManager,
    private val playerManager: PlayerManager,
) {
    private val logger: Logger = LoggerFactory.getLogger(AuthManager::class.java)
    private val json = Json { ignoreUnknownKeys = true }

    /**
     * Checks if player has valid session
     */
    fun hasValidSession(username: String, ip: String): Boolean {
        return redisManager.withJedis { jedis ->
            val sessionKey = "session:$username:$ip"
            val sessionData = jedis.get(sessionKey)
            val isValid = if (sessionData != null) {
                try {
                    val sessionInfo = json.decodeFromString<SessionData>(sessionData)
                    val expiresAt = sessionInfo.expiresAt.toLong()
                    val valid = expiresAt > System.currentTimeMillis()
                    logger.info("Session for $username from $ip is valid: $valid, expires at: $expiresAt")
                    valid
                } catch (e: Exception) {
                    logger.error("Error deserializing session data for $username", e)
                    false
                }
            } else {
                logger.info("No session found for $username from $ip")
                false
            }
            isValid
        } ?: run {
            logger.info("Redis connection failed for session check for $username from $ip")
            false
        }
    }

    /**
     * Creates a session for a user with specified duration
     */
    fun createSession(username: String, ip: String, durationSeconds: Int = 14 * 24 * 60 * 60): Boolean {
        return try {
            redisManager.withJedis { jedis ->
                val currentTime = System.currentTimeMillis()
                val expiresAt = currentTime + (durationSeconds * 1000L)

                val sessionData = SessionData(
                    createdAt = currentTime.toString(),
                    expiresAt = expiresAt.toString(),
                    ip = ip
                )
                val sessionJson = json.encodeToString(sessionData)
                jedis.setex("session:$username:$ip", durationSeconds.toLong(), sessionJson)

                logger.info("Created session for $username from $ip with duration $durationSeconds seconds")
                true
            } ?: false
        } catch (e: Exception) {
            logger.error("Error creating session for $username from $ip", e)
            false
        }
    }

    /**
     * Creates a valid session after web authentication
     */
    suspend fun createSessionAfterWebAuth(request: WebAuthRequest): AuthValidationResult {
        try {
            val pendingData = getPendingAuthData(request.username)
                ?: return AuthValidationResult(false, "No pending authentication found for ${request.username}")

            val validationResult = validateAuthRequest(request, pendingData)
            if (!validationResult.success) {
                return validationResult
            }

            val existingProfile = playerManager.findPlayerByProvider(request.authProvider, request.providerId)
            if (existingProfile != null && existingProfile.playerName != request.username) {
                return AuthValidationResult(
                    false,
                    "This ${request.authProvider} account is already linked to another Minecraft account: ${existingProfile.playerName}"
                )
            }

            val uuid = UUID.fromString(pendingData.uuid)
            var profile = playerManager.getPlayerProfile(uuid)
            val isNewProfile = profile == null

            if (isNewProfile) {
                // Create new profile
                profile = playerManager.createNewProfile(uuid, request, pendingData)
                playerManager.savePlayerProfile(profile)
                logger.info("Created new profile for ${request.username} with ${request.authProvider} authentication")
            } else {
                // Update existing profile
                profile = playerManager.updateExistingProfile(profile!!, request)
                playerManager.updatePlayerProfile(profile)
                logger.info("Updated existing profile for ${request.username} with ${request.authProvider} authentication")
            }

            createSession(request.username, request.ip)
            clearPendingAuth(request.username)

            return AuthValidationResult(
                success = true,
                accountStatus = if (isNewProfile) "new" else "existing"
            )
        } catch (e: Exception) {
            logger.error("Error creating session from web auth", e)
            return AuthValidationResult(false, "Internal server error")
        }
    }


    /**
     * Create a session after authenticating from website
     */
    suspend fun createSessionFromWebAuth(request: WebAuthRequest): AuthValidationResult {
        try {
            // Get pending auth data
            val pendingData = getPendingAuthData(request.username)
                ?: return AuthValidationResult(false, "No pending authentication found for ${request.username}")

            // Validate the request
            val validationResult = validateAuthRequest(request, pendingData)
            if (!validationResult.success) {
                return validationResult
            }

            // Check if this provider account is already linked to another Minecraft account
            val existingProfile = playerManager.findPlayerByProvider(request.authProvider, request.providerId)
            if (existingProfile != null && existingProfile.playerName != request.username) {
                return AuthValidationResult(
                    false,
                    "This ${request.authProvider} account is already linked to another Minecraft account: ${existingProfile.playerName}"
                )
            }

            val uuid = UUID.fromString(pendingData.uuid)
            var profile = playerManager.getPlayerProfile(uuid)
            val isNewProfile = profile == null

            if (isNewProfile) {
                // Create new profile
                profile = playerManager.createNewProfile(uuid, request, pendingData)
                playerManager.savePlayerProfile(profile)
                logger.info("Created new profile for ${request.username} with ${request.authProvider} authentication")
            } else {
                // Update existing profile
                profile = playerManager.updateExistingProfile(profile!!, request)
                playerManager.updatePlayerProfile(profile)
                logger.info("Updated existing profile for ${request.username} with ${request.authProvider} authentication")
            }

            // Create session
            createSession(request.username, request.ip)

            // Clear pending auth
            clearPendingAuth(request.username)

            return AuthValidationResult(
                success = true,
                accountStatus = if (isNewProfile) "new" else "existing"
            )

        } catch (e: Exception) {
            logger.error("Error creating session from web auth", e)
            return AuthValidationResult(false, "Internal server error")
        }
    }

    /**
     * Invalidates a session for a specific user and IP
     */
    fun invalidateSession(username: String, ip: String): Boolean {
        return try {
            redisManager.withJedis { jedis ->
                val sessionKey = "session:$username:$ip"
                val deleted = jedis.del(sessionKey)
                logger.info("Invalidated session for $username from $ip")
                deleted > 0
            } ?: false
        } catch (e: Exception) {
            logger.error("Error invalidating session for $username from $ip", e)
            false
        }
    }

    /**
     * Invalidates all sessions for a specific user
     */
    fun invalidateAllUserSessions(username: String): Boolean {
        return try {
            redisManager.withJedis { jedis ->
                val pattern = "session:$username:*"
                val keys = jedis.keys(pattern)
                if (keys.isNotEmpty()) {
                    val deleted = jedis.del(*keys.toTypedArray())
                    logger.info("Invalidated $deleted sessions for $username")
                    deleted > 0
                } else {
                    logger.info("No sessions found to invalidate for $username")
                    true
                }
            } ?: false
        } catch (e: Exception) {
            logger.error("Error invalidating all sessions for $username", e)
            false
        }
    }

    /**
     * Gets session information for a user and IP
     */
    fun getSessionInfo(username: String, ip: String): SessionData? {
        return try {
            redisManager.withJedis { jedis ->
                val sessionKey = "session:$username:$ip"
                val sessionData = jedis.get(sessionKey)
                if (sessionData != null) {
                    json.decodeFromString<SessionData>(sessionData)
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            logger.error("Error getting session info for $username from $ip", e)
            null
        }
    }

    /**
     * Get pending auth data from redis
     */
    fun getPendingAuthData(username: String): PendingAuthData? {
        return redisManager.withJedis { jedis ->
            val pendingJson = jedis.get("auth_pending:$username")
            if (pendingJson != null) {
                try {
                    json.decodeFromString<PendingAuthData>(pendingJson)
                } catch (e: Exception) {
                    logger.error("Error parsing pending auth data for $username", e)
                    null
                }
            } else null
        }
    }

    /**
     * Validate auth request
     */
    suspend fun validateAuthRequest(request: WebAuthRequest, pendingData: PendingAuthData): AuthValidationResult {
        // Validate provider ID is not empty
        if (request.providerId.isBlank()) {
            return AuthValidationResult(false, "Invalid provider ID")
        }

        // Validate email for certain providers
        if (request.authProvider == "google" && request.email.isNullOrBlank()) {
            return AuthValidationResult(false, "Email is required for Google authentication")
        }

        if (pendingData.ip != request.ip) {
            logger.warn("IP mismatch for ${request.username}: pending=${pendingData.ip}, request=${request.ip}")
        }

        return AuthValidationResult(true)
    }

    fun clearPendingAuth(username: String) {
        redisManager.withJedis { jedis ->
            jedis.del("auth_pending:$username")
        }
    }


}