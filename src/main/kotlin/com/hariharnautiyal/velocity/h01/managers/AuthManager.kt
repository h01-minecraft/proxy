package com.hariharnautiyal.velocity.h01.managers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.hariharnautiyal.velocity.h01.models.*
import java.util.UUID

class AuthManager(
    private val redisManager: RedisManager,
    private val playerManager: PlayerManager,
) {
    private val logger: Logger = LoggerFactory.getLogger(AuthManager::class.java)

    /**
     * Handle authentication when a player login to velocity server
     */
    suspend fun handleLogin(
        uuid: UUID,
        username: String,
        ip: String,
        isBedrock: Boolean
    ): LoginResult {
        return try {
            logger.info("Login attempt: $username (${if (isBedrock) "Bedrock" else "Java"}) from $ip")

            val currentOnlineIP = playerManager.onlinePlayers[username]
            if (currentOnlineIP != null && currentOnlineIP != ip) {
                logger.warn("Account $username already in use from $currentOnlineIP, denying $ip")
                return LoginResult.ACCOUNT_IN_USE
            }

            if (isBedrock) {
                handleBedrockLogin(uuid, username, ip)
                return LoginResult.SUCCESS
            } else {
                handleJavaLogin(uuid, username, ip)
                return LoginResult.SUCCESS
            }

        } catch (e: Exception) {
            logger.error("Error handling login for ${username}", e)
            LoginResult.ERROR
        }
    }

    /**
     * Handle authentication of the player with a bedrock edition
     */
    private suspend fun handleBedrockLogin(
        uuid: UUID,
        username: String,
        ip: String
    ) {
        var profile = playerManager.getPlayerProfile(uuid)

        if (profile == null) {
            profile = PlayerProfile(
                _id = uuid.toString(),
                playerName = username,
                edition = Edition.BEDROCK,
                coins = 0, // Starting coins
                registeredIP = ip,
                registrationTime = System.currentTimeMillis()
            )
            playerManager.savePlayerProfile(profile)
            logger.info("Created new Bedrock profile for $username")
        } else {
            val updatedProfile = profile.copy(
                playerName = username,
                lastUpdated = System.currentTimeMillis()
            )
            playerManager.updatePlayerProfile(updatedProfile)
        }

        playerManager.markPlayerOnline(username, ip)
        logger.info("Bedrock player $username logged in successfully")
    }

    /**
     * Handle authentication of the player with a java edition
     */
    private suspend fun handleJavaLogin(
        uuid: UUID,
        username: String,
        ip: String
    ) {
        var profile = playerManager.getPlayerProfile(uuid)

        if (profile == null) {
            profile = PlayerProfile(
                _id = uuid.toString(),
                playerName = username,
                edition = Edition.JAVA,
                coins = 0,
                registeredIP = ip,
                registrationTime = System.currentTimeMillis()
            )
            playerManager.savePlayerProfile(profile)
            logger.info("Created new Bedrock profile for $username")
        } else {
            val updatedProfile = profile.copy(
                playerName = username,
                lastUpdated = System.currentTimeMillis()
            )
            playerManager.updatePlayerProfile(updatedProfile)
        }

        playerManager.markPlayerOnline(username, ip)
        logger.info("Bedrock player $username logged in successfully")
    }



    /**
     * Handle event when player logout from server
     */
    fun handleLogout(username: String) {
        playerManager.onlinePlayers.remove(username)

        redisManager.withJedis { jedis -> jedis.del("active:$username")}

        logger.info("Player $username logged out")
    }
}

