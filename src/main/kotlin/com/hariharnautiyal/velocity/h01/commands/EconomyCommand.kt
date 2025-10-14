package com.hariharnautiyal.velocity.h01.commands

import com.hariharnautiyal.velocity.h01.gui.WalletGUI
import com.hariharnautiyal.velocity.h01.managers.*
import com.hariharnautiyal.velocity.h01.models.*
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.geysermc.floodgate.api.FloodgateApi

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
            source.sendMessage(
                    Component.text("Only players can use this command", NamedTextColor.RED)
            )
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
            val result =
                    economyManager.transferBalance(player.uniqueId, targetPlayer.uniqueId, amount)

            when (result) {
                TransferBalanceResponse.SUCCESS -> {
                    player.sendMessage(Component.text("Payment successful", NamedTextColor.GREEN))
                    val targetOnline = server.getPlayer(targetPlayer.uniqueId).orElse(null)
                    if (targetOnline != null) {
                        if (floodgateApi.isFloodgatePlayer(targetPlayer.uniqueId)) {
                            walletGUI.transferReceivedGUI(targetOnline, player, amount)
                        } else {
                            targetOnline.sendMessage(
                                    Component.text(
                                            "${player.username} transferred $amount hash coins to you",
                                            NamedTextColor.YELLOW
                                    )
                            )
                        }
                    }
                }
                TransferBalanceResponse.NOT_ENOUGH_FUNDS -> {
                    player.sendMessage(Component.text("Not enough balance", NamedTextColor.YELLOW))
                }
                TransferBalanceResponse.ERROR -> {
                    player.sendMessage(Component.text("Failed to pay", NamedTextColor.RED))
                }
                TransferBalanceResponse.PLAYER_NOT_FOUND -> {
                    player.sendMessage(
                            Component.text("Player not found in database", NamedTextColor.RED)
                    )
                }
                TransferBalanceResponse.INVALID_AMOUNT -> {
                    player.sendMessage(
                            Component.text(
                                    "You cannot send 0 or a negative amount.",
                                    NamedTextColor.RED
                            )
                    )
                }
                TransferBalanceResponse.CANNOT_PAY_SELF -> {
                    player.sendMessage(
                            Component.text("You cannot send money to yourself.", NamedTextColor.RED)
                    )
                }
            }
        }
    }

    private fun sendUsage(player: Player) {
        player.sendMessage(
                Component.text(
                        "--- Pay Command Help ---",
                        NamedTextColor.DARK_GRAY,
                        TextDecoration.STRIKETHROUGH
                )
        )
        player.sendMessage(Component.text("/pay <player> <amount>", NamedTextColor.YELLOW))
    }

    override fun suggest(invocation: SimpleCommand.Invocation): List<String> {
        val args = invocation.arguments()
        if (args.size == 0) {
            return server.allPlayers.map { it.username }
        }
        if (args.size == 1) {
            return server.allPlayers.map { it.username }.filter {
                it.startsWith(args[0], ignoreCase = true)
            }
        }
        return emptyList()
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
            source.sendMessage(
                    Component.text("Only players can use this command", NamedTextColor.RED)
            )
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
                            player.sendMessage(
                                    Component.text(
                                            "${result.balance} Hash Coins",
                                            NamedTextColor.YELLOW
                                    )
                            )
                    is GetBalanceResponse.PlayerNotFound ->
                            player.sendMessage(
                                    Component.text("Player not found", NamedTextColor.RED)
                            )
                    is GetBalanceResponse.Error ->
                            player.sendMessage(
                                    Component.text("Failed to view wallet", NamedTextColor.RED)
                            )
                }
            }
        }
    }

    private fun sendUsage(player: Player) {
        player.sendMessage(
                Component.text(
                        "--- Balance Command Help ---",
                        NamedTextColor.DARK_GRAY,
                        TextDecoration.STRIKETHROUGH
                )
        )
        player.sendMessage(Component.text("/bal", NamedTextColor.YELLOW))
        player.sendMessage(Component.text("/pay", NamedTextColor.YELLOW))
    }

    override fun hasPermission(invocation: SimpleCommand.Invocation): Boolean {
        return true
    }
}
