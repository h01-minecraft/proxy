package com.hariharnautiyal.velocity.h01.managers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/managers/RedeemManager;", "", "redisManager", "Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "economyManager", "Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;", "playerManager", "Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;", "logger", "Lorg/slf4j/Logger;", "(Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;Lorg/slf4j/Logger;)V", "redeemCode", "Lcom/hariharnautiyal/velocity/h01/models/RedeemCodeResponse;", "username", "", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h01"})
public final class RedeemManager {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.EconomyManager economyManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager = null;
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    
    public RedeemManager(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.EconomyManager economyManager, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager, @org.jetbrains.annotations.NotNull()
    org.slf4j.Logger logger) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object redeemCode(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.RedeemCodeResponse> $completion) {
        return null;
    }
}