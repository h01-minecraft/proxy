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

    suspend fun transferBalance(from: UUID, to: UUID, amount: Long): TransferBalanceResponse {
        if (from == to) {
            return TransferBalanceResponse.CANNOT_PAY_SELF
        }

        if (amount < 1) {
            return TransferBalanceResponse.INVALID_AMOUNT
        }

        val fromPlayer = playerManager.getPlayerProfile(from)
        val toPlayer = playerManager.getPlayerProfile(to)

        if (fromPlayer == null || toPlayer == null) {
            return TransferBalanceResponse.PLAYER_NOT_FOUND
        }

        if (fromPlayer.coins < amount) {
            return TransferBalanceResponse.NOT_ENOUGH_FUNDS
        }

        val fromUpdateResult = mongodbManager.playersCollection.updateOne(
            eq(PlayerProfile::_id.name, from.toString()),
            inc(PlayerProfile::coins.name, -amount)
        )
        val toUpdateResult = mongodbManager.playersCollection.updateOne(
            eq(PlayerProfile::_id.name, to.toString()),
            inc(PlayerProfile::coins.name, amount)
        )

        return if (fromUpdateResult.wasAcknowledged() && toUpdateResult.wasAcknowledged()) {
            TransferBalanceResponse.SUCCESS
        } else {
            TransferBalanceResponse.ERROR
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