package com.hariharnautiyal.velocity.h01.gui

import com.hariharnautiyal.velocity.h01.models.*
import com.hariharnautiyal.velocity.h01.managers.*
import org.geysermc.floodgate.api.FloodgateApi
import org.geysermc.cumulus.form.SimpleForm
import org.geysermc.cumulus.form.CustomForm
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WalletGUI(
    private val economyManager: EconomyManager,
    private val floodgateApi: FloodgateApi,
    private val playerManager: PlayerManager,
    private val server: ProxyServer
) {
    private val scope = CoroutineScope(Dispatchers.IO)

    fun mainMenu(player: Player) {
        val form = SimpleForm.builder()
            .title("Wallet")
            .button("Balance")
            .button("Pay")
            .validResultHandler { response ->
                when (response.clickedButtonId()) {
                    0 -> {
                        scope.launch {
                            val result = economyManager.getBalance(player.uniqueId)
                            when (result) {
                                is GetBalanceResponse.Success -> balance(player, result.balance)
                                is GetBalanceResponse.PlayerNotFound -> playerNotFound(player)
                                is GetBalanceResponse.Error -> error(player)
                            }
                        }
                    }
                    1 -> friendsListForm(player)
                }
            }
            .build()

        floodgateApi.sendForm(player.uniqueId, form)
    }

    private fun friendsListForm(player: Player) {
        val onlinePlayers = server.allPlayers.filter { it.uniqueId != player.uniqueId }

        if (onlinePlayers.isEmpty()) {
            val form = SimpleForm.builder()
                .title("Pay")
                .content("There are no other players online.")
                .button("Back")
                .validResultHandler { mainMenu(player) }
                .build()
            floodgateApi.sendForm(player.uniqueId, form)
            return
        }

        val formBuilder = SimpleForm.builder()
            .title("Pay")
            .content("Select a player to pay:")

        onlinePlayers.forEach {
            formBuilder.button(it.username)
        }

        formBuilder.validResultHandler { response ->
            val recipient = onlinePlayers[response.clickedButtonId()]
            payAmountForm(player, recipient)
        }

        floodgateApi.sendForm(player.uniqueId, formBuilder.build())
    }

    private fun payAmountForm(sender: Player, recipient: Player) {
        val form = CustomForm.builder()
            .title("Pay ${recipient.username}")
            .input("Amount", "Enter the amount to send")
            .validResultHandler { response ->
                val amountString = response.next() as? String
                val amount = amountString?.toLongOrNull()

                if (amount == null || amount <= 0) {
                    val errorForm = SimpleForm.builder()
                        .title("Invalid Amount")
                        .content("Please enter a valid positive number.")
                        .button("Back")
                        .validResultHandler { payAmountForm(sender, recipient) }
                        .build()
                    floodgateApi.sendForm(sender.uniqueId, errorForm)
                    return@validResultHandler
                }

                scope.launch {
                    val result = economyManager.transferBalance(sender.uniqueId, recipient.uniqueId, amount)
                    when (result) {
                        TransferBalanceResponse.SUCCESS -> {
                            val successForm = SimpleForm.builder()
                                .title("Payment Successful")
                                .content("You have successfully sent $amount coins to ${recipient.username}.")
                                .button("Back to Main Menu")
                                .validResultHandler { mainMenu(sender) }
                                .build()
                            floodgateApi.sendForm(sender.uniqueId, successForm)
                            receivedCoins(recipient, sender, amount)
                        }
                        TransferBalanceResponse.NOT_ENOUGH_FUNDS -> {
                            val errorForm = SimpleForm.builder()
                                .title("Insufficient Funds")
                                .content("You do not have enough coins to make this payment.")
                                .button("Back")
                                .validResultHandler { mainMenu(sender) }
                                .build()
                            floodgateApi.sendForm(sender.uniqueId, errorForm)
                        }
                        else -> error(sender)
                    }
                }
            }
            .build()
        floodgateApi.sendForm(sender.uniqueId, form)
    }

    fun balance(player: Player, balance: Long) {
        val form = SimpleForm.builder()
            .title("Balance")
            .content("Your balance is: $balance coins")
            .button("Back")
            .validResultHandler { mainMenu(player) }
            .build()
        floodgateApi.sendForm(player.uniqueId, form)
    }

    fun playerNotFound(player: Player) {
        val form = SimpleForm.builder()
            .title("Not found")
            .content("The requested player is not found in our database.")
            .button("Back")
            .validResultHandler { mainMenu(player) }
            .build()

        floodgateApi.sendForm(player.uniqueId, form)
    }

    fun error(player: Player) {
        val form = SimpleForm.builder()
            .title("Failed")
            .content("The transaction failed. Please try again later.")
            .button("Back")
            .validResultHandler { mainMenu(player) }
            .build()

        floodgateApi.sendForm(player.uniqueId, form)
    }

    fun receivedCoins(player: Player, tPlayer: Player, amount: Long) {
        val form = SimpleForm.builder()
            .title("Received Hash Coins")
            .content("${tPlayer.username} sent you $amount hash coins")
            .button("OK")
            .build()

        floodgateApi.sendForm(player.uniqueId, form)
    }
}