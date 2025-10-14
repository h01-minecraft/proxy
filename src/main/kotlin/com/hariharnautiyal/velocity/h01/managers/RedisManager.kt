package com.hariharnautiyal.velocity.h01.managers

import com.google.inject.Singleton
import com.velocitypowered.api.proxy.ProxyServer
import kotlin.concurrent.thread
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig
import redis.clients.jedis.JedisPubSub

@Singleton
class RedisManager(
        host: String = "localhost",
        port: Int = 6379,
        password: String? = null,
        database: Int = 0,
        timeout: Int = 2000,
        isDevelopment: Boolean = false,
) {
    private val logger: Logger = LoggerFactory.getLogger(RedisManager::class.java)
    private val jedisPool: JedisPool
    private val subscriberJedis: Jedis = Jedis(host, port)

    init {
        try {
            val poolConfig =
                    JedisPoolConfig().apply {
                        maxTotal = 20
                        maxIdle = 10
                        minIdle = 5
                    }

            jedisPool =
                    if (isDevelopment) JedisPool(poolConfig, host, port, timeout)
                    else JedisPool(poolConfig, host, port, timeout, password, database)

            logger.info("Redis connection pool initialized for $host:$port")
        } catch (e: Exception) {
            logger.error("Failed to initialize Redis connection pool", e)
            throw RuntimeException("Redis initialization failed", e)
        }
    }

    fun <T> withJedis(action: (Jedis) -> T): T? {
        return try {
            jedisPool.resource.use { jedis -> action(jedis) }
        } catch (e: Exception) {
            logger.error("Error executing Redis operation", e)
            null
        }
    }

    fun startSubscriber(server: ProxyServer) {
        thread(isDaemon = true) {
            try {
                val pubSub =
                        object : JedisPubSub() {
                            override fun onPMessage(
                                    pattern: String?,
                                    channel: String?,
                                    message: String?
                            ) {
                                if (pattern == "emit:*" && channel != null && message != null) {
                                    val username = channel.substringAfter("emit:")
                                    server.getPlayer(username).ifPresent { player ->
                                        val formattedMessage = "<${player.username}> $message"
                                        val component =
                                                LegacyComponentSerializer.legacyAmpersand()
                                                        .deserialize(formattedMessage)
                                        server.allPlayers.forEach { p -> p.sendMessage(component) }
                                    }
                                }
                            }
                        }
                subscriberJedis.psubscribe(pubSub, "emit:*")
            } catch (e: Exception) {
                logger.error(e.toString())
            }
        }
    }

    fun close() {
        try {
            jedisPool.close()
            logger.info("Redis connection pool closed")
        } catch (e: Exception) {
            logger.error("Error closing Redis connection pool", e)
        }
    }
}
