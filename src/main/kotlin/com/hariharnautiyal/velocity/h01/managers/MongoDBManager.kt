package com.hariharnautiyal.velocity.h01.managers

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.google.inject.Singleton
import com.hariharnautiyal.velocity.h01.models.*

@Singleton
class MongoDBManager(
    host: String = "localhost",
    port: Int = 27017,
    username: String? = null,
    password: String? = null,
    isDevelopment: Boolean,
) {
    private val logger: Logger = LoggerFactory.getLogger(MongoDBManager::class.java)
    private val connectionString = if (isDevelopment) {
        "mongodb://${host}:${port}"
    } else {
        "mongodb://${username}:${password}@${host}:${port}"
    }
    private val databaseName = "h01"
    private val playerCollectionName = "players"
    private val teamCollectionName = "teams"
    private val shopItemCollectionName = "items"
    private val categoryCollectionName = "categories"

    private val mongoClient: MongoClient = MongoClient.create(connectionString)
    private val database: MongoDatabase = mongoClient.getDatabase(databaseName)
    val playersCollection: MongoCollection<PlayerProfile> = database.getCollection<PlayerProfile>(playerCollectionName)
    val teamsCollection: MongoCollection<Team> = database.getCollection<Team>(teamCollectionName)
    val shopItemCollection: MongoCollection<ShopItem> = database.getCollection<ShopItem>(shopItemCollectionName)
    val categoryCollection: MongoCollection<Category> = database.getCollection<Category>(categoryCollectionName)
    val prefixCollection: MongoCollection<Prefix> = database.getCollection<Prefix>("prefixes")
    val vaultCollection: MongoCollection<Vault> = database.getCollection<Vault>("vaults")


    init {
        logger.info("MongoDB Manager initialized with connection to $connectionString")
    }

    fun close() {
        mongoClient.close()
        logger.info("MongoDB connection closed")
    }
}