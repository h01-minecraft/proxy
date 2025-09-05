package com.hariharnautiyal.velocity.h01.managers

import com.mongodb.client.model.Filters
import com.mongodb.client.model.Filters.and
import com.mongodb.client.model.Filters.elemMatch
import com.mongodb.client.model.Filters.or
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.ReplaceOptions
import com.mongodb.client.model.Updates.set
import com.hariharnautiyal.velocity.h01.models.*
import kotlinx.coroutines.flow.firstOrNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

class PlayerManager(
    private val mongoDBManager: MongoDBManager,
    private val redisManager: RedisManager,
) {
    private val logger: Logger = LoggerFactory.getLogger(PlayerManager::class.java)
    val onlinePlayers = ConcurrentHashMap<String, String>()

    /**
     * Fetch player's profile from mongodb
     */
    suspend fun getPlayerProfile(uuid: UUID): PlayerProfile? {
        return try {
            mongoDBManager.playersCollection.find(
                Filters.eq(PlayerProfile::_id.name, uuid.toString())
            ).firstOrNull()
        } catch (e: Exception) {
            logger.error("Error getting player profile for $uuid", e)
            null
        }
    }

    /**
     * Saves player's profile to mongodb
     */
    suspend fun savePlayerProfile(profile: PlayerProfile) {
        try {
            mongoDBManager.playersCollection.insertOne(profile)
        } catch (e: Exception) {
            logger.error("Error saving player profile for ${profile.playerName}", e)
        }
    }

    /**
     * Updates player's profile to mongodb
     */
    suspend fun updatePlayerProfile(profile: PlayerProfile) {
        try {
            val filter = Filters.eq(PlayerProfile::_id.name, profile._id)
            val options = ReplaceOptions().upsert(true)
            mongoDBManager.playersCollection.replaceOne(filter, profile, options)
        } catch (e: Exception) {
            logger.error("Error updating player profile for ${profile.playerName}", e)
        }
    }

    /**
     * Utility function to mark player online
     */
    fun markPlayerOnline(username: String, ip: String) {
        onlinePlayers[username] = ip
        redisManager.withJedis { jedis -> jedis.setex("active:$username", 3600, ip) }
    }

    /**
     * Utility function to fetch the total count of players in the server
     */
    fun getOnlinePlayerCount(): Int = onlinePlayers.size

    /**
     * Utility function to fetch all online players
     */
    fun getOnlinePlayers(): Set<String> = onlinePlayers.keys.toSet()

    /**
     * Fetch the profile from the provider
     */
    suspend fun findPlayerByProvider(provider: String, providerId: String): PlayerProfile? {
        return try {
            mongoDBManager.playersCollection
                .find(
                    or(
                        and(
                            Filters.eq(PlayerProfile::authProvider.name, provider),
                            Filters.eq(PlayerProfile::providerId.name, providerId)
                        ),
                        elemMatch(
                            PlayerProfile::linkedAccounts.name,
                            and(
                                Filters.eq(LinkedAccount::provider.name, provider),
                                Filters.eq(LinkedAccount::providerId.name, providerId)
                            )
                        )
                    )
                )
                .firstOrNull()
        } catch (e: Exception) {
            logger.error("Error finding player by provider", e)
            null
        }
    }

    /**
     * Creates a profile instance
     */
    fun createNewProfile(uuid: UUID, request: WebAuthRequest, pendingData: PendingAuthData): PlayerProfile {
        return PlayerProfile(
            _id = uuid.toString(),
            playerName = request.username,
            edition = Edition.JAVA,
            coins = 100,
            registeredIP = request.ip,
            registrationTime = System.currentTimeMillis(),
            authProvider = request.authProvider,
            providerId = request.providerId,
            providerUsername = request.providerUsername,
            providerEmail = request.email,
            isVerified = true,
            linkedAccounts = mutableListOf(
                LinkedAccount(
                    provider = request.authProvider,
                    providerId = request.providerId,
                    providerUsername = request.providerUsername,
                    providerEmail = request.email
                )
            )
        )
    }

    /**
     * Update the existing profile instance
     */
    fun updateExistingProfile(profile: PlayerProfile, request: WebAuthRequest): PlayerProfile {
        // Check if this provider is already linked
        val existingLink = profile.linkedAccounts.find {
            it.provider == request.authProvider && it.providerId == request.providerId
        }

        val updatedLinkedAccounts = if (existingLink == null) {
            // Add new linked account
            profile.linkedAccounts.toMutableList().apply {
                add(LinkedAccount(
                    provider = request.authProvider,
                    providerId = request.providerId,
                    providerUsername = request.providerUsername,
                    providerEmail = request.email
                ))
            }
        } else {
            // Update existing linked account
            profile.linkedAccounts.map { account ->
                if (account.provider == request.authProvider && account.providerId == request.providerId) {
                    account.copy(
                        providerUsername = request.providerUsername,
                        providerEmail = request.email,
                        linkedAt = System.currentTimeMillis()
                    )
                } else {
                    account
                }
            }.toMutableList()
        }

        return profile.copy(
            playerName = request.username,
            lastUpdated = System.currentTimeMillis(),
            authProvider = request.authProvider, // Update primary auth provider
            providerId = request.providerId,
            providerUsername = request.providerUsername,
            providerEmail = request.email,
            isVerified = true,
            linkedAccounts = updatedLinkedAccounts
        )
    }


    suspend fun findPlayerByEmail(email: String): PlayerProfile? {
        return try {
            mongoDBManager.playersCollection
                .find(
                    or(
                        Filters.eq(PlayerProfile::providerEmail.name, email),
                        elemMatch(
                            PlayerProfile::linkedAccounts.name,
                            Filters.eq(LinkedAccount::providerEmail.name, email)
                        )
                    )
                )
                .firstOrNull()
        } catch (e: Exception) {
            logger.error("Error finding player by email", e)
            null
        }
    }

    fun isPlayerOnline(username: String): Boolean {
        return redisManager.withJedis { jedis ->
            val key = jedis.get("active:$username")
            key != null
        } ?: false
    }

    suspend fun getPlayerByName(username: String): PlayerProfile? {
        return mongoDBManager.playersCollection.find(
            Filters.eq(PlayerProfile::playerName.name, username)
        ).firstOrNull()
    }

    suspend fun setPlayerTeam(username: String, teamId: String?) {
        mongoDBManager.playersCollection.updateOne(
            eq(PlayerProfile::playerName.name, username),
            set(PlayerProfile::teamId.name, teamId)
        )
    }
}