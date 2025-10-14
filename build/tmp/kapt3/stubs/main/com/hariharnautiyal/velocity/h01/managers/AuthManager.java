package com.hariharnautiyal.velocity.h01.managers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/managers/AuthManager;", "", "redisManager", "Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "playerManager", "Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;", "(Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;)V", "logger", "Lorg/slf4j/Logger;", "handleLogin", "Lcom/hariharnautiyal/velocity/h01/models/LoginResult;", "uuid", "Ljava/util/UUID;", "username", "", "ip", "isBedrock", "", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLogout", "", "h01"})
public final class AuthManager {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager = null;
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    
    public AuthManager(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager) {
        super();
    }
    
    /**
     * Handle authentication when a player login to velocity server
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object handleLogin(@org.jetbrains.annotations.NotNull()
    java.util.UUID uuid, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String ip, boolean isBedrock, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.LoginResult> $completion) {
        return null;
    }
    
    /**
     * Handle event when player logout from server
     */
    public final void handleLogout(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
}