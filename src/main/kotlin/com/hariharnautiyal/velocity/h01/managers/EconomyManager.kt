package com.hariharnautiyal.velocity.h01.managers

import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates.inc
import java.util.UUID
import com.hariharnautiyal.velocity.h01.models.*
import kotlinx.coroutines.flow.firstOrNull

class EconomyManager(
    private val mongodbManager: MongoDBManager,
    private val playerManager: PlayerManager,
    private val redisManager: RedisManager
) {
    suspend fun addBalance(playerUUID: UUID, incrementValue: Long) {
        mongodbManager.playersCollection.updateOne(
            eq(PlayerProfile::_id.name, playerUUID.toString()),
            inc(PlayerProfile::coins.name, incrementValue)
        )
    }

    suspend fun getBalance(playerUUID: UUID): GetBalanceResponse {
        val profile = mongodbManager.playersCollection.find(
            eq(PlayerProfile::_id.name, playerUUID.toString())
        )
        return when {
            profile.firstOrNull() == null -> GetBalanceResponse.PlayerNotFound
            else -> GetBalanceResponse.Success(profile.firstOrNull()?.coins ?: 0L)
        }
    }

    suspend fun transferBalance(senderUUID: UUID, receiverUUID: UUID, transferAmount: Long): TransferBalanceResponse {
        try {
            val senderProfile = playerManager.getPlayerProfile(senderUUID);
            val receiverProfile = playerManager.getPlayerProfile(receiverUUID);
            if (senderProfile == null || receiverProfile == null) return TransferBalanceResponse.PLAYER_NOT_FOUND
            val senderBalance = senderProfile.coins;
            if (senderBalance < transferAmount) {
                return TransferBalanceResponse.NOT_ENOUGH_FUNDS;
            }
            addBalance(senderUUID, -transferAmount)
            addBalance(receiverUUID, transferAmount)
            return TransferBalanceResponse.SUCCESS;
        } catch (e: Exception) {
            e.printStackTrace()
            return TransferBalanceResponse.ERROR;
        }
    }

    suspend fun openJavaShop(playerName: String): OpenShopResult {
        try {
            redisManager.withJedis { jedis ->
                jedis.setex("shop_open:$playerName", 60, "true")
                jedis.publish("shop_events", "SHOP_OPENED:$playerName") // also add if directly want to open from the category
            }
            return OpenShopResult.SUCCESS
        } catch (e: Exception) {
            e.printStackTrace()
            return OpenShopResult.ERROR
        }
    }
}
