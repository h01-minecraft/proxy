package com.hariharnautiyal.velocity.h01.managers

import com.hariharnautiyal.velocity.h01.models.*
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import redis.clients.jedis.exceptions.JedisException
import java.util.UUID

class RedeemManager(
    private val redisManager: RedisManager,
    private val economyManager: EconomyManager,
    private val playerManager: PlayerManager,
    private val logger: org.slf4j.Logger,
) {

    suspend fun redeemCode(username: String, code: String): RedeemCodeResponse {
        if (username.isBlank() || code.isBlank()) {
            logger.warn("Invalid input: username='$username', code='$code'")
            return RedeemCodeResponse.ERROR
        }

        try {
            val profile = playerManager.getPlayerByName(username) ?: return RedeemCodeResponse.PLAYER_NOT_FOUND.also {
                logger.info("Player not found: username='$username'")
            }

            val redeemedCodes = profile.redeemedCodes
            if (redeemedCodes.contains(code)) {
                logger.info("Code already redeemed: username='$username', code='$code'")
                return RedeemCodeResponse.ALREADY_REDEEMED
            }

            val redeemCodeJson = redisManager.withJedis { jedis ->
                jedis.get("redeem_code:$code")
            }
            if (redeemCodeJson == null) {
                logger.info("Invalid code: code='$code'")
                return RedeemCodeResponse.INVALID_CODE
            }


            val redeemCode = try {
                Gson().fromJson(redeemCodeJson, RedeemCode::class.java)
            } catch (e: JsonSyntaxException) {
                logger.error("Failed to parse redeem code JSON: code='$code', error=${e.message}")
                return RedeemCodeResponse.ERROR
            }

            try {
                economyManager.addBalance(UUID.fromString(profile._id), redeemCode.coins)

                val updatedRedeemedCodes = redeemedCodes.toMutableList().apply { add(code) }
                val updatedProfile = profile.copy(redeemedCodes = updatedRedeemedCodes)

                playerManager.updatePlayerProfile(updatedProfile)

                logger.info("Code redeemed successfully: username='$username', code='$code', coins=${redeemCode.coins}")
                return RedeemCodeResponse.SUCCESS
            } catch (e: Exception) {
                logger.error("Failed to process redemption: username='$username', code='$code', error=${e.message}")
                return RedeemCodeResponse.ERROR
            }
        } catch (e: JedisException) {
            logger.error("Redis error during redeemCode: username='$username', code='$code', error=${e.message}")
            return RedeemCodeResponse.ERROR
        } catch (e: Exception) {
            logger.error("Unexpected error during redeemCode: username='$username', code='$code', error=${e.message}")
            return RedeemCodeResponse.ERROR
        }
    }
}
