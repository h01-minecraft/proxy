package com.hariharnautiyal.velocity.h01.events

import com.hariharnautiyal.velocity.h01.managers.RedisManager
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.player.PlayerChatEvent
import com.velocitypowered.api.proxy.Player

class ChatEvents(private val redisManager: RedisManager) {

    @Subscribe
    fun onPlayerChat(event: PlayerChatEvent) {
        val player: Player = event.player
        val message: String = event.message

        event.setResult(PlayerChatEvent.ChatResult.denied())

        val channel = "msg:${player.username}"
        redisManager.withJedis { jedis -> jedis.publish(channel, message) }
    }
}
