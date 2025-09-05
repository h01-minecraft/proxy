package com.hariharnautiyal.velocity.h01.events

import com.google.inject.Inject
import com.velocitypowered.api.event.ResultedEvent
import com.hariharnautiyal.velocity.h01.managers.*
import com.hariharnautiyal.velocity.h01.models.*
import kotlinx.coroutines.*
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.geysermc.floodgate.api.FloodgateApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.velocitypowered.api.event.PostOrder
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.connection.LoginEvent
import com.velocitypowered.api.event.connection.DisconnectEvent

class AuthenticationEvents @Inject constructor(
    private val authManager: AuthManager,
    private val api: FloodgateApi,
) {
    private val logger: Logger = LoggerFactory.getLogger(AuthenticationEvents::class.java)

    @Subscribe(order = PostOrder.FIRST)
    fun onPlayerLogin(event: LoginEvent) {
        val player = event.player

        try {
            val result = runBlocking {
                authManager.handleLogin(player.uniqueId, player.username, player.remoteAddress.address.hostAddress, api.isFloodgatePlayer(player.uniqueId))
            }

            logger.info("Login result for ${player.username}: $result")
            when (result) {
                LoginResult.SUCCESS -> {
                    logger.info("${player.username} logged in successfully")
                }
                LoginResult.NEEDS_WEB_AUTH -> {
                    event.result = ResultedEvent.ComponentResult.denied(
                        Component.text()
                            .append(Component.text("Please register your account at:", NamedTextColor.YELLOW))
                            .append(Component.text("\n[https://h01.in/login]", NamedTextColor.AQUA))
                            .append(Component.text("\nThen rejoin to play!", NamedTextColor.GREEN))
                            .build()
                    )
                    logger.info("[Needs web auth] Set login result to denied for ${player.username}")
                }
                LoginResult.ACCOUNT_IN_USE -> {
                    event.result = ResultedEvent.ComponentResult.denied(
                        Component.text("This account is already logged in from another location!", NamedTextColor.RED)
                    )
                    logger.info("Set login result to denied for account in use for ${player.username}")
                }
                LoginResult.AUTH_PENDING -> {
                    event.result = ResultedEvent.ComponentResult.denied(
                        Component.text()
                            .append(Component.text("Authentication in progress...", NamedTextColor.YELLOW))
                            .append(Component.text("\nComplete your registration at:", NamedTextColor.GRAY))
                            .append(Component.text("\n[https://h01.in/login]", NamedTextColor.AQUA))
                            .build()
                    )
                    logger.info("Set login result to denied for auth pending for ${player.username}")
                }
                LoginResult.ERROR -> {
                    event.result = ResultedEvent.ComponentResult.denied(
                        Component.text("Authentication error. Please try again.", NamedTextColor.RED)
                    )
                    logger.info("Set login result to denied for error for ${player.username}")
                }
            }
        } catch (e: Exception) {
            logger.error("Error in login event for ${player.username}", e)
            event.result = ResultedEvent.ComponentResult.denied(
                Component.text("Login failed. Please try again.", NamedTextColor.RED)
            )
        }
    }

    @Subscribe(order = PostOrder.LAST)
    fun onPlayerDisconnect(event: DisconnectEvent) {
        authManager.handleLogout(event.player.username)
    }
}