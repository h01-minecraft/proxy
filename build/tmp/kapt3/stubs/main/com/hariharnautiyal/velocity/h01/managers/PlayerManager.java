package com.hariharnautiyal.velocity.h01.managers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\'J \u0010(\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\'R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;", "", "mongoDBManager", "Lcom/hariharnautiyal/velocity/h01/managers/MongoDBManager;", "redisManager", "Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "(Lcom/hariharnautiyal/velocity/h01/managers/MongoDBManager;Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;)V", "logger", "Lorg/slf4j/Logger;", "onlinePlayers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getOnlinePlayers", "()Ljava/util/concurrent/ConcurrentHashMap;", "createNewProfile", "Lcom/hariharnautiyal/velocity/h01/models/PlayerProfile;", "uuid", "Ljava/util/UUID;", "request", "Lcom/hariharnautiyal/velocity/h01/models/WebAuthRequest;", "pendingData", "Lcom/hariharnautiyal/velocity/h01/models/PendingAuthData;", "getOnlinePlayerCount", "", "", "getPlayerByDiscordId", "discordId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayerByName", "username", "getPlayerProfile", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPlayerOnline", "", "markPlayerOnline", "", "ip", "savePlayerProfile", "profile", "(Lcom/hariharnautiyal/velocity/h01/models/PlayerProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPlayerTeam", "teamId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlayerProfile", "h01"})
public final class PlayerManager {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.MongoDBManager mongoDBManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager = null;
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> onlinePlayers = null;
    
    public PlayerManager(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.MongoDBManager mongoDBManager, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> getOnlinePlayers() {
        return null;
    }
    
    /**
     * Fetch player's profile from mongodb
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayerProfile(@org.jetbrains.annotations.NotNull()
    java.util.UUID uuid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.PlayerProfile> $completion) {
        return null;
    }
    
    /**
     * Saves player's profile to mongodb
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object savePlayerProfile(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.PlayerProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Updates player's profile to mongodb
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlayerProfile(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.PlayerProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Utility function to mark player online
     */
    public final void markPlayerOnline(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String ip) {
    }
    
    /**
     * Utility function to fetch the total count of players in the server
     */
    public final int getOnlinePlayerCount() {
        return 0;
    }
    
    /**
     * Utility function to fetch all online players
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> getOnlinePlayers() {
        return null;
    }
    
    /**
     * Creates a profile instance
     */
    @org.jetbrains.annotations.NotNull()
    public final com.hariharnautiyal.velocity.h01.models.PlayerProfile createNewProfile(@org.jetbrains.annotations.NotNull()
    java.util.UUID uuid, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.WebAuthRequest request, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.PendingAuthData pendingData) {
        return null;
    }
    
    public final boolean isPlayerOnline(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayerByName(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.PlayerProfile> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setPlayerTeam(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.Nullable()
    java.lang.String teamId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayerByDiscordId(@org.jetbrains.annotations.NotNull()
    java.lang.String discordId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.PlayerProfile> $completion) {
        return null;
    }
}