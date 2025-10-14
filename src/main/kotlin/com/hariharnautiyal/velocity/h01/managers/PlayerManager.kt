package com.hariharnautiyal.velocity.h01.managers

import com.hariharnautiyal.velocity.h01.models.*
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Filters.and
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Filters.or
import com.mongodb.client.model.ReplaceOptions
import com.mongodb.client.model.Updates.set
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import kotlinx.coroutines.flow.firstOrNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PlayerManager(
        private val mongoDBManager: MongoDBManager,
        private val redisManager: RedisManager,
) {
    private val logger: Logger = LoggerFactory.getLogger(PlayerManager::class.java)
    val onlinePlayers = ConcurrentHashMap<String, String>()

    /** Fetch player's profile from mongodb */
    suspend fun getPlayerProfile(uuid: UUID): PlayerProfile? {
        return try {
            mongoDBManager
                    .playersCollection
                    .find(Filters.eq(PlayerProfile::_id.name, uuid.toString()))
                    .firstOrNull()
        } catch (e: Exception) {
            logger.error("Error getting player profile for $uuid", e)
            null
        }
    }

    /** Saves player's profile to mongodb */
    suspend fun savePlayerProfile(profile: PlayerProfile) {
        try {
            mongoDBManager.playersCollection.insertOne(profile)
        } catch (e: Exception) {
            logger.error("Error saving player profile for ${profile.playerName}", e)
        }
    }

    /** Updates player's profile to mongodb */
    suspend fun updatePlayerProfile(profile: PlayerProfile) {
        try {
            val filter = Filters.eq(PlayerProfile::_id.name, profile._id)
            val options = ReplaceOptions().upsert(true)
            mongoDBManager.playersCollection.replaceOne(filter, profile, options)
        } catch (e: Exception) {
            logger.error("Error updating player profile for ${profile.playerName}", e)
        }
    }

    /** Utility function to mark player online */
    fun markPlayerOnline(username: String, ip: String) {
        onlinePlayers[username] = ip
        redisManager.withJedis { jedis -> jedis.setex("active:$username", 3600, ip) }
    }

    /** Utility function to fetch the total count of players in the server */
    fun getOnlinePlayerCount(): Int = onlinePlayers.size

    /** Utility function to fetch all online players */
    fun getOnlinePlayers(): Set<String> = onlinePlayers.keys.toSet()

    /** Creates a profile instance */
    fun createNewProfile(
            uuid: UUID,
            request: WebAuthRequest,
            pendingData: PendingAuthData
    ): PlayerProfile {
        return PlayerProfile(
                _id = uuid.toString(),
                playerName = request.username,
                edition = Edition.JAVA,
                coins = 100,
                registeredIP = request.ip,
                registrationTime = System.currentTimeMillis(),
        )
    }

    fun isPlayerOnline(username: String): Boolean {
        return redisManager.withJedis { jedis ->
            val key = jedis.get("active:$username")
            key != null
        }
                ?: false
    }

    suspend fun getPlayerByName(username: String): PlayerProfile? {
        return mongoDBManager
                .playersCollection
                .find(Filters.eq(PlayerProfile::playerName.name, username))
                .firstOrNull()
    }

    suspend fun setPlayerTeam(username: String, teamId: String?) {
        mongoDBManager.playersCollection.updateOne(
                eq(PlayerProfile::playerName.name, username),
                set(PlayerProfile::teamId.name, teamId)
        )
    }

    suspend fun getPlayerByDiscordId(discordId: String): PlayerProfile? {
        return try {
            mongoDBManager
                    .playersCollection
                    .find(Filters.eq(PlayerProfile::discordId.name, discordId))
                    .firstOrNull()
        } catch (e: Exception) {
            logger.error("Error getting player profile for discordId $discordId", e)
            null
        }
    }
}
