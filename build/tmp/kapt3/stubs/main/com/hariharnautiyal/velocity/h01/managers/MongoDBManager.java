package com.hariharnautiyal.velocity.h01.managers;

@com.google.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010+\u001a\u00020,R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u000e\u0010#\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u000fR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000f\u00a8\u0006-"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/managers/MongoDBManager;", "", "host", "", "port", "", "username", "password", "isDevelopment", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "categoryCollection", "Lcom/mongodb/kotlin/client/coroutine/MongoCollection;", "Lcom/hariharnautiyal/velocity/h01/models/Category;", "getCategoryCollection", "()Lcom/mongodb/kotlin/client/coroutine/MongoCollection;", "categoryCollectionName", "connectionString", "database", "Lcom/mongodb/kotlin/client/coroutine/MongoDatabase;", "databaseName", "logger", "Lorg/slf4j/Logger;", "mongoClient", "Lcom/mongodb/kotlin/client/coroutine/MongoClient;", "playerCollectionName", "playersCollection", "Lcom/hariharnautiyal/velocity/h01/models/PlayerProfile;", "getPlayersCollection", "prefixCollection", "Lcom/hariharnautiyal/velocity/h01/models/Prefix;", "getPrefixCollection", "shopItemCollection", "Lcom/hariharnautiyal/velocity/h01/models/ShopItem;", "getShopItemCollection", "shopItemCollectionName", "teamCollectionName", "teamsCollection", "Lcom/hariharnautiyal/velocity/h01/models/Team;", "getTeamsCollection", "vaultCollection", "Lcom/hariharnautiyal/velocity/h01/models/Vault;", "getVaultCollection", "close", "", "h01"})
public final class MongoDBManager {
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String connectionString = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String databaseName = "h01";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String playerCollectionName = "players";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String teamCollectionName = "teams";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String shopItemCollectionName = "items";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String categoryCollectionName = "categories";
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoClient mongoClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.PlayerProfile> playersCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Team> teamsCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.ShopItem> shopItemCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Category> categoryCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Prefix> prefixCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Vault> vaultCollection = null;
    
    public MongoDBManager(@org.jetbrains.annotations.NotNull()
    java.lang.String host, int port, @org.jetbrains.annotations.Nullable()
    java.lang.String username, @org.jetbrains.annotations.Nullable()
    java.lang.String password, boolean isDevelopment) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.PlayerProfile> getPlayersCollection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Team> getTeamsCollection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.ShopItem> getShopItemCollection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Category> getCategoryCollection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Prefix> getPrefixCollection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mongodb.kotlin.client.coroutine.MongoCollection<com.hariharnautiyal.velocity.h01.models.Vault> getVaultCollection() {
        return null;
    }
    
    public final void close() {
    }
}