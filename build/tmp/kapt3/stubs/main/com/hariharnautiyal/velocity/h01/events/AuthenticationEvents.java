package com.hariharnautiyal.velocity.h01.events;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/events/AuthenticationEvents;", "", "authManager", "Lcom/hariharnautiyal/velocity/h01/managers/AuthManager;", "api", "Lorg/geysermc/floodgate/api/FloodgateApi;", "(Lcom/hariharnautiyal/velocity/h01/managers/AuthManager;Lorg/geysermc/floodgate/api/FloodgateApi;)V", "logger", "Lorg/slf4j/Logger;", "onPlayerDisconnect", "", "event", "Lcom/velocitypowered/api/event/connection/DisconnectEvent;", "onPlayerLogin", "Lcom/velocitypowered/api/event/connection/LoginEvent;", "h01"})
public final class AuthenticationEvents {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.AuthManager authManager = null;
    @org.jetbrains.annotations.NotNull()
    private final org.geysermc.floodgate.api.FloodgateApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    
    @com.google.inject.Inject()
    public AuthenticationEvents(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.AuthManager authManager, @org.jetbrains.annotations.NotNull()
    org.geysermc.floodgate.api.FloodgateApi api) {
        super();
    }
    
    @com.velocitypowered.api.event.Subscribe(order = com.velocitypowered.api.event.PostOrder.FIRST)
    public final void onPlayerLogin(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.connection.LoginEvent event) {
    }
    
    @com.velocitypowered.api.event.Subscribe(order = com.velocitypowered.api.event.PostOrder.LAST)
    public final void onPlayerDisconnect(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.connection.DisconnectEvent event) {
    }
}