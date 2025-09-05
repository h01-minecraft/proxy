package com.hariharnautiyal.velocity.h01.managers;

@com.google.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J'\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002H\u00130\u0015\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "", "host", "", "port", "", "password", "database", "timeout", "isDevelopment", "", "(Ljava/lang/String;ILjava/lang/String;IIZ)V", "jedisPool", "Lredis/clients/jedis/JedisPool;", "logger", "Lorg/slf4j/Logger;", "close", "", "withJedis", "T", "action", "Lkotlin/Function1;", "Lredis/clients/jedis/Jedis;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "h01"})
public final class RedisManager {
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final redis.clients.jedis.JedisPool jedisPool = null;
    
    public RedisManager(@org.jetbrains.annotations.NotNull()
    java.lang.String host, int port, @org.jetbrains.annotations.Nullable()
    java.lang.String password, int database, int timeout, boolean isDevelopment) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>T withJedis(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super redis.clients.jedis.Jedis, ? extends T> action) {
        return null;
    }
    
    public final void close() {
    }
    
    public RedisManager() {
        super();
    }
}