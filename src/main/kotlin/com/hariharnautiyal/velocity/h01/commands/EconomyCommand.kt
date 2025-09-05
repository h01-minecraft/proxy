package com.hariharnautiyal.velocity.h01.commands

import com.hariharnautiyal.velocity.h01.gui.WalletGUI
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.geysermc.floodgate.api.FloodgateApi
import com.hariharnautiyal.velocity.h01.models.*
import com.hariharnautiyal.velocity.h01.managers.*

class PayCommand(
    private val economyManager: EconomyManager,
    private val server: ProxyServer,
    private val floodgateApi: FloodgateApi,
    private val walletGUI: WalletGUI
) : SimpleCommand {
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun execute(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()
        val args = invocation.arguments()

        if (source !is Player) {
            source.sendMessage(Component.text("Only players can use this command", NamedTextColor.RED))
            return
        }

        handleCommand(source, args)
    }


    private fun handleCommand(player: Player, args: Array<String>) {
        scope.launch {
            val isBedrockPlayer = floodgateApi.isFloodgatePlayer(player.uniqueId)

            if (isBedrockPlayer && args.isEmpty()) {
                walletGUI.mainMenu(player)
                return@launch
            }

            if (args.size < 2) {
                sendUsage(player)
                return@launch
            }

            val targetPlayer = server.getPlayer(args[0]).orElse(null)
            if (targetPlayer == null) {
                player.sendMessage(Component.text("Player not found", NamedTextColor.RED))
                return@launch
            }
            val amount = args[1].toLongOrNull() ?: 0
            val result = economyManager.transferBalance(player.uniqueId, targetPlayer.uniqueId, amount)
            val message = when (result) {
                TransferBalanceResponse.SUCCESS -> {
                    Component.text("Payment successful", NamedTextColor.GREEN)
                }
                TransferBalanceResponse.NOT_ENOUGH_FUNDS -> {
                    Component.text("Not enough balance", NamedTextColor.YELLOW)
                }
                TransferBalanceResponse.ERROR -> {
                    Component.text("Failed to pay", NamedTextColor.RED)
                }
                TransferBalanceResponse.PLAYER_NOT_FOUND -> {
                    Component.text("Player not found in database", NamedTextColor.RED)
                }
            }

            if (result === TransferBalanceResponse.SUCCESS) {
                targetPlayer.sendMessage(Component.text("${player.username} transferred $amount hash coins to you", NamedTextColor.YELLOW))
            }

            player.sendMessage(message)
        }
    }

    private fun sendUsage(player: Player) {
        player.sendMessage(Component.text("§8§m--- Pay Command Help §8§m---", NamedTextColor.DARK_GRAY))
        player.sendMessage(Component.text("/pay <player> <amount>", NamedTextColor.YELLOW))
    }

    override fun suggest(invocation: SimpleCommand.Invocation): List<String> {
        val args = invocation.arguments()

        return server.allPlayers.map { it.username }
            .filter {
                it.startsWith(args[1], ignoreCase = true) && it.lowercase() != invocation.source()
                    .let { src -> if (src is Player) src.username.lowercase() else "" }
            }
    }

    override fun hasPermission(invocation: SimpleCommand.Invocation): Boolean {
        return true
    }
}

class BalanceCommand(
    private val economyManager: EconomyManager,
    private val server: ProxyServer,
    private val floodgateApi: FloodgateApi,
    private val walletGUI: WalletGUI
) : SimpleCommand {
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun execute(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()
        val args = invocation.arguments()

        if (source !is Player) {
            source.sendMessage(Component.text("Only players can use this command", NamedTextColor.RED))
            return
        }

        handleCommand(source)
    }


    private fun handleCommand(player: Player) {
        scope.launch {
            val result = economyManager.getBalance(player.uniqueId)

            val isBedrockPlayer = floodgateApi.isFloodgatePlayer(player.uniqueId)

            if (isBedrockPlayer) {
                when (result) {
                    is GetBalanceResponse.Success -> walletGUI.balance(player, result.balance)
                    is GetBalanceResponse.Error -> walletGUI.error(player)
                    is GetBalanceResponse.PlayerNotFound -> walletGUI.playerNotFound(player)
                }
            } else {
                when (result) {
                    is GetBalanceResponse.Success ->
                        player.sendMessage(Component.text(
                            "${result.balance} Hash Coins",
                            NamedTextColor.YELLOW)
                        )
                    is GetBalanceResponse.PlayerNotFound -> player.sendMessage(
                        Component.text(
                            "Player not found",
                            NamedTextColor.RED
                        )
                    )
                    is GetBalanceResponse.Error -> player.sendMessage(
                        Component.text(
                            "Failed to view wallet",
                            NamedTextColor.RED
                        )
                    )
                }
            }
        }
    }

    private fun sendUsage(player: Player) {
        player.sendMessage(Component.text("§8§m--- Balance Command Help §8§m---", NamedTextColor.DARK_GRAY))
        player.sendMessage(Component.text("/bal", NamedTextColor.YELLOW))
    }

    override fun hasPermission(invocation: SimpleCommand.Invocation): Boolean {
        return true
    }
}