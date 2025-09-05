package com.hariharnautiyal.velocity.h01.managers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;", "", "mongodbManager", "Lcom/hariharnautiyal/velocity/h01/managers/MongoDBManager;", "playerManager", "Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;", "redisManager", "Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "(Lcom/hariharnautiyal/velocity/h01/managers/MongoDBManager;Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;)V", "addBalance", "", "playerUUID", "Ljava/util/UUID;", "incrementValue", "", "(Ljava/util/UUID;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBalance", "Lcom/hariharnautiyal/velocity/h01/models/GetBalanceResponse;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openJavaShop", "Lcom/hariharnautiyal/velocity/h01/models/OpenShopResult;", "playerName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transferBalance", "Lcom/hariharnautiyal/velocity/h01/models/TransferBalanceResponse;", "senderUUID", "receiverUUID", "transferAmount", "(Ljava/util/UUID;Ljava/util/UUID;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h01"})
public final class EconomyManager {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.MongoDBManager mongodbManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager = null;
    
    public EconomyManager(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.MongoDBManager mongodbManager, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addBalance(@org.jetbrains.annotations.NotNull()
    java.util.UUID playerUUID, long incrementValue, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBalance(@org.jetbrains.annotations.NotNull()
    java.util.UUID playerUUID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.GetBalanceResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object transferBalance(@org.jetbrains.annotations.NotNull()
    java.util.UUID senderUUID, @org.jetbrains.annotations.NotNull()
    java.util.UUID receiverUUID, long transferAmount, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.TransferBalanceResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object openJavaShop(@org.jetbrains.annotations.NotNull()
    java.lang.String playerName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hariharnautiyal.velocity.h01.models.OpenShopResult> $completion) {
        return null;
    }
}