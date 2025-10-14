package com.hariharnautiyal.velocity.h01.commands

import com.google.gson.Gson
import com.hariharnautiyal.velocity.h01.managers.PlayerManager
import com.hariharnautiyal.velocity.h01.managers.RedisManager
import com.hariharnautiyal.velocity.h01.models.CLink
import com.hariharnautiyal.velocity.h01.models.Link
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration

class LinkCommand(
        private val server: ProxyServer,
        private val redisManager: RedisManager,
        private val playerManager: PlayerManager
) : SimpleCommand {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val gson = Gson()

    override fun execute(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()
        val args = invocation.arguments()

        if (source !is Player) {
            source.sendMessage(
                    Component.text("Only players can use this command.", NamedTextColor.RED)
            )
            return
        }

        if (args.size != 1) {
            sendUsage(source)
            return
        }

        source.sendMessage(Component.text("Verifying your link code...", NamedTextColor.GRAY))
        handleCommand(source, args[0])
    }

    private fun handleCommand(player: Player, code: String) {
        scope.launch {
            val linkKey = "link:$code"
            val linkJson = redisManager.withJedis { jedis -> jedis.get(linkKey) }

            if (linkJson == null) {
                player.sendMessage(
                        Component.text(
                                "This link code is invalid or has expired.",
                                NamedTextColor.RED
                        )
                )
                return@launch
            }

            val linkData = gson.fromJson(linkJson, Link::class.java)
            val discordId = linkData.discordUid

            val currentPlayerProfile = playerManager.getPlayerProfile(player.uniqueId)
            if (currentPlayerProfile == null) {
                player.sendMessage(
                        Component.text(
                                "Could not find your player profile. Please relog and try again.",
                                NamedTextColor.RED
                        )
                )
                return@launch
            }

            if (currentPlayerProfile.discordId != null) {
                player.sendMessage(
                        Component.text(
                                "Your Minecraft account is already linked to a Discord account.",
                                NamedTextColor.RED
                        )
                )
                return@launch
            }

            val existingDiscordUser = playerManager.getPlayerByDiscordId(discordId)
            if (existingDiscordUser != null) {
                player.sendMessage(
                        Component.text(
                                "That Discord account is already linked to the Minecraft user: ${existingDiscordUser.playerName}",
                                NamedTextColor.RED
                        )
                )
                return@launch
            }

            val updatedProfile = currentPlayerProfile.copy(discordId = discordId)
            playerManager.updatePlayerProfile(updatedProfile)

            val confirmationPayload = gson.toJson(CLink(minecraft_playername = player.username))
            val confirmationChannel = "clink:$discordId"

            redisManager.withJedis { jedis ->
                jedis.publish(confirmationChannel, confirmationPayload)
                jedis.del(linkKey)
            }

            player.sendMessage(
                    Component.text("Success!", NamedTextColor.GREEN)
                            .append(
                                    Component.text(
                                            " Your Minecraft and Discord accounts are now linked.",
                                            NamedTextColor.GRAY
                                    )
                            )
            )
        }
    }

    private fun sendUsage(player: Player) {
        player.sendMessage(
                Component.text(
                        "--- Discord Link Command Help ---",
                        NamedTextColor.DARK_GRAY,
                        TextDecoration.STRIKETHROUGH
                )
        )
        player.sendMessage(
                Component.text("Usage: ", NamedTextColor.GRAY)
                        .append(Component.text("/link [code]", NamedTextColor.YELLOW))
        )
    }

    override fun hasPermission(invocation: SimpleCommand.Invocation): Boolean {
        return true
    }
}
