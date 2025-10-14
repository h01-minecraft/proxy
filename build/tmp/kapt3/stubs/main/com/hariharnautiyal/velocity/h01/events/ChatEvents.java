package com.hariharnautiyal.velocity.h01.events;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/events/ChatEvents;", "", "redisManager", "Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "(Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;)V", "onPlayerChat", "", "event", "Lcom/velocitypowered/api/event/player/PlayerChatEvent;", "h01"})
public final class ChatEvents {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager = null;
    
    public ChatEvents(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager) {
        super();
    }
    
    @com.velocitypowered.api.event.Subscribe()
    public final void onPlayerChat(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.player.PlayerChatEvent event) {
    }
}