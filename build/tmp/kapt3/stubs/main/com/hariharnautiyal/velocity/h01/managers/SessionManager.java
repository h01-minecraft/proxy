package com.hariharnautiyal.velocity.h01.managers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010 \u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u001e\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/managers/SessionManager;", "", "redisManager", "Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "playerManager", "Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;", "(Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;)V", "json", "Lkotlinx/serialization/json/Json;", "logger", "Lorg/slf4j/Logger;", "clearPendingAuth", "", "username", "", "createSession", "", "ip", "durationSeconds", "", "createSessionAfterWebAuth", "Lcom/hariharnautiyal/velocity/h01/models/AuthValidationResult;", "request", "Lcom/hariharnautiyal/velocity/h01/models/WebAuthRequest;", "(Lcom/hariharnautiyal/velocity/h01/models/WebAuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSessionFromWebAuth", "getPendingAuthData", "Lcom/hariharnautiyal/velocity/h01/models/PendingAuthData;", "getSessionInfo", "Lcom/hariharnautiyal/velocity/h01/models/SessionData;", "hasValidSession", "invalidateAllUserSessions", "invalidateSession", "validateAuthRequest", "pendingData", "(Lcom/hariharnautiyal/velocity/h01/models/WebAuthRequest;Lcom/hariharnautiyal/velocity/h01/models/PendingAuthData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h01"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager = null;
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.serialization.json.Json json = null;
    
    public SessionManager(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager) {
        super();
    }
    
    /**
     * Checks if player has valid session
     */
    public final boolean hasValidSession(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String ip) {
        return false;
    }
    
    /**
     * Creates a session for a user with specified duration
     */
    public final boolean createSession(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String ip, int durationSeconds) {
        return false;
    }
    
    /**
     * Creates a valid session after web authentication
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createSessionAfterWebAuth(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.WebAuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.AuthValidationResult> $completion) {
        return null;
    }
    
    /**
     * Create a session after authenticating from website
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createSessionFromWebAuth(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.WebAuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.AuthValidationResult> $completion) {
        return null;
    }
    
    /**
     * Invalidates a session for a specific user and IP
     */
    public final boolean invalidateSession(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String ip) {
        return false;
    }
    
    /**
     * Invalidates all sessions for a specific user
     */
    public final boolean invalidateAllUserSessions(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
        return false;
    }
    
    /**
     * Gets session information for a user and IP
     */
    @org.jetbrains.annotations.Nullable()
    public final com.hariharnautiyal.velocity.h01.models.SessionData getSessionInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String ip) {
        return null;
    }
    
    /**
     * Get pending auth data from redis
     */
    @org.jetbrains.annotations.Nullable()
    public final com.hariharnautiyal.velocity.h01.models.PendingAuthData getPendingAuthData(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
        return null;
    }
    
    /**
     * Validate auth request
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object validateAuthRequest(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.WebAuthRequest request, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.PendingAuthData pendingData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.AuthValidationResult> $completion) {
        return null;
    }
    
    public final void clearPendingAuth(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
}