package com.hariharnautiyal.velocity.h01

import com.google.inject.Inject
import com.hariharnautiyal.velocity.h01.commands.BalanceCommand
import com.hariharnautiyal.velocity.h01.commands.LinkCommand
import com.hariharnautiyal.velocity.h01.commands.PayCommand
import com.hariharnautiyal.velocity.h01.events.AuthenticationEvents
import com.hariharnautiyal.velocity.h01.events.ChatEvents
import com.hariharnautiyal.velocity.h01.gui.WalletGUI
import com.hariharnautiyal.velocity.h01.managers.*
import com.velocitypowered.api.command.CommandManager
import com.velocitypowered.api.command.CommandMeta
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import java.nio.file.Files
import java.nio.file.Path
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.geysermc.floodgate.api.FloodgateApi
import org.slf4j.Logger

@Plugin(
        id = "h01",
        name = "h01",
        version = BuildConstants.VERSION,
        description =
                "UserEncrypt minecraft velocity plugin to prevent from username stealing in offline mode servers.",
        url = "https://harihar.site/projects/userencrypt",
        authors = ["Harihar Nautiyal"]
)
class Main
@Inject
constructor(
        val logger: Logger,
        val server: ProxyServer,
        @DataDirectory private val dataDirectory: Path
) {
    private lateinit var config: PluginConfig
    private lateinit var mongoDBManager: MongoDBManager
    private lateinit var redisManager: RedisManager
    private lateinit var playerManager: PlayerManager
    private lateinit var economyManager: EconomyManager
    private lateinit var authManager: AuthManager

    private lateinit var walletGUI: WalletGUI
    private lateinit var balanceCommand: BalanceCommand
    private lateinit var payCommand: PayCommand
    private lateinit var linkCommand: LinkCommand

    private lateinit var authenticationEvents: AuthenticationEvents
    private lateinit var chatEvents: ChatEvents

    private val floodgateApi: FloodgateApi? by lazy {
        try {
            FloodgateApi.getInstance()
        } catch (e: Exception) {
            logger.warn("FloodgateApi is not available: ${e.message}")
            null
        }
    }

    init {
        logger.info("Hello world")
    }

    private fun loadConfig() {
        try {
            val configFile = dataDirectory.resolve("config.json").toFile()
            if (!configFile.exists()) {
                logger.info("Config file not found, creating default config.json")
                Files.createDirectories(dataDirectory)
                configFile.writeText(
                        """
                    {
                        "webHost": "localhost",
                        "webPort": 1798,
                        "backendApi": "test-api-key",
                        "isDevelopment": true,
                        "websiteUrl": "http://localhost:4000",
                        "redis": {
                            "host": "localhost",
                            "port": 6379,
                            "password": null
                        },
                        "mongo": {
                            "host": "localhost",
                            "port": 27017,
                            "database": "h01",
                            "username": null,
                            "password": null
                        }
                    }
                    """.trimIndent()
                )
            }

            logger.debug("Config file content: ${configFile.readText()}")

            val json = Json { ignoreUnknownKeys = true }
            config = json.decodeFromString(configFile.readText())
            logger.info("Configuration loaded successfully: $config")
        } catch (e: Exception) {
            logger.error("Failed to load config.json: ${e.message}", e)
            config =
                    PluginConfig(
                            isDevelopment = true,
                            mongo =
                                    MongoDBConfiguration(
                                            host = "localhost",
                                            port = 27017,
                                            database = "h01",
                                            username = null,
                                            password = null
                                    ),
                            redis =
                                    RedisConfiguration(
                                            host = "localhost",
                                            port = 6379,
                                            password = null
                                    ),
                    )
        }
    }

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        logger.info("Loading configuration...")
        loadConfig()

        startManagers()

        logger.info("Initializing economy")
        logger.info("Registering commands")

        registerCommands()
    }

    @Subscribe
    fun onProxyShutdown(event: ProxyShutdownEvent) {
        logger.info("Shutting down economy")

        try {
            if (::redisManager.isInitialized) {
                redisManager.close()
            }
            if (::mongoDBManager.isInitialized) {
                mongoDBManager.close()
            }
        } catch (e: Exception) {
            logger.error("Error during shutdown cleanup: ${e.message}", e)
        }
    }

    private fun startManagers() {
        try {
            redisManager =
                    RedisManager(
                            host = config.redis.host,
                            port = config.redis.port,
                            password = config.redis.password,
                            isDevelopment = config.isDevelopment
                    )
            mongoDBManager =
                    MongoDBManager(
                            host = config.mongo.host,
                            port = config.mongo.port,
                            username = config.mongo.username,
                            password = config.mongo.password,
                            isDevelopment = config.isDevelopment
                    )

            playerManager = PlayerManager(mongoDBManager, redisManager)
            economyManager = EconomyManager(mongoDBManager, playerManager, redisManager)
            authManager = AuthManager(redisManager, playerManager)

            floodgateApi?.let { walletGUI = WalletGUI(economyManager, it, playerManager, server) }

            balanceCommand = BalanceCommand(economyManager, server, floodgateApi!!, walletGUI)
            payCommand = PayCommand(economyManager, server, floodgateApi!!, walletGUI)
            linkCommand = LinkCommand(server, redisManager, playerManager)

            authenticationEvents =
                    if (floodgateApi != null) {
                        logger.info("FloodgateApi available - Bedrock support enabled")
                        AuthenticationEvents(authManager, floodgateApi!!)
                    } else {
                        logger.warn("FloodgateApi not available - Bedrock support disabled")
                        return
                    }

            chatEvents = ChatEvents(redisManager)

            redisManager.startSubscriber(server)

            server.eventManager.register(this, authenticationEvents)
            server.eventManager.register(this, chatEvents)
        } catch (e: Exception) {
            logger.error("Failed to start web server: ${e.message}", e)
        }
    }

    private fun registerCommands() {
        val commandManager: CommandManager = server.commandManager

        val payCommandMeta: CommandMeta =
                commandManager.metaBuilder("transfer").aliases("p", "pay").plugin(this).build()

        val balanceCommandMeta: CommandMeta =
                commandManager.metaBuilder("balance").aliases("b", "bal").plugin(this).build()

        val linkCommandMeta: CommandMeta =
                commandManager.metaBuilder("link").aliases("l", "li").plugin(this).build()

        commandManager.register(payCommandMeta, payCommand)
        commandManager.register(balanceCommandMeta, balanceCommand)
        commandManager.register(linkCommandMeta, linkCommand)

        logger.info("Commands registered")
    }
}

@Serializable
data class PluginConfig(
        val webHost: String = "localhost",
        val webPort: Int = 1798,
        val backendApi: String = "test-api-key",
        val websiteUrl: String = "http://localhost:4000",
        val isDevelopment: Boolean = false,
        val mongo: MongoDBConfiguration =
                MongoDBConfiguration(
                        host = "localhost",
                        port = 27017,
                        database = "h01",
                        username = null,
                        password = null
                ),
        val redis: RedisConfiguration =
                RedisConfiguration(host = "localhost", port = 6379, password = null),
)

@Serializable
data class MongoDBConfiguration(
        val host: String,
        val port: Int,
        val database: String,
        val username: String? = null,
        val password: String? = null
)

@Serializable
data class RedisConfiguration(val host: String, val port: Int, val password: String? = null)
