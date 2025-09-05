package com.hariharnautiyal.velocity.h01;

@com.velocitypowered.api.plugin.Plugin(id = "h01", name = "h01", version = "1.0-SNAPSHOT", description = "UserEncrypt minecraft velocity plugin to prevent from username stealing in offline mode servers.", url = "https://harihar.site/projects/userencrypt", authors = {"Harihar Nautiyal"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0007J\u0010\u0010,\u001a\u00020(2\u0006\u0010*\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020(H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/Main;", "", "logger", "Lorg/slf4j/Logger;", "server", "Lcom/velocitypowered/api/proxy/ProxyServer;", "dataDirectory", "Ljava/nio/file/Path;", "(Lorg/slf4j/Logger;Lcom/velocitypowered/api/proxy/ProxyServer;Ljava/nio/file/Path;)V", "authManager", "Lcom/hariharnautiyal/velocity/h01/managers/AuthManager;", "authenticationEvents", "Lcom/hariharnautiyal/velocity/h01/events/AuthenticationEvents;", "balanceCommand", "Lcom/hariharnautiyal/velocity/h01/commands/BalanceCommand;", "config", "Lcom/hariharnautiyal/velocity/h01/PluginConfig;", "economyManager", "Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;", "floodgateApi", "Lorg/geysermc/floodgate/api/FloodgateApi;", "getFloodgateApi", "()Lorg/geysermc/floodgate/api/FloodgateApi;", "floodgateApi$delegate", "Lkotlin/Lazy;", "getLogger", "()Lorg/slf4j/Logger;", "mongoDBManager", "Lcom/hariharnautiyal/velocity/h01/managers/MongoDBManager;", "payCommand", "Lcom/hariharnautiyal/velocity/h01/commands/PayCommand;", "playerManager", "Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;", "redisManager", "Lcom/hariharnautiyal/velocity/h01/managers/RedisManager;", "getServer", "()Lcom/velocitypowered/api/proxy/ProxyServer;", "walletGUI", "Lcom/hariharnautiyal/velocity/h01/gui/WalletGUI;", "loadConfig", "", "onProxyInitialization", "event", "Lcom/velocitypowered/api/event/proxy/ProxyInitializeEvent;", "onProxyShutdown", "Lcom/velocitypowered/api/event/proxy/ProxyShutdownEvent;", "registerCommands", "startManagers", "h01"})
public final class Main {
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final com.velocitypowered.api.proxy.ProxyServer server = null;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.file.Path dataDirectory = null;
    private com.hariharnautiyal.velocity.h01.PluginConfig config;
    private com.hariharnautiyal.velocity.h01.managers.MongoDBManager mongoDBManager;
    private com.hariharnautiyal.velocity.h01.managers.RedisManager redisManager;
    private com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager;
    private com.hariharnautiyal.velocity.h01.managers.EconomyManager economyManager;
    private com.hariharnautiyal.velocity.h01.managers.AuthManager authManager;
    private com.hariharnautiyal.velocity.h01.gui.WalletGUI walletGUI;
    private com.hariharnautiyal.velocity.h01.commands.BalanceCommand balanceCommand;
    private com.hariharnautiyal.velocity.h01.commands.PayCommand payCommand;
    private com.hariharnautiyal.velocity.h01.events.AuthenticationEvents authenticationEvents;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy floodgateApi$delegate = null;
    
    @com.google.inject.Inject()
    public Main(@org.jetbrains.annotations.NotNull()
    org.slf4j.Logger logger, @org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.ProxyServer server, @com.velocitypowered.api.plugin.annotation.DataDirectory()
    @org.jetbrains.annotations.NotNull()
    java.nio.file.Path dataDirectory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.slf4j.Logger getLogger() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velocitypowered.api.proxy.ProxyServer getServer() {
        return null;
    }
    
    private final org.geysermc.floodgate.api.FloodgateApi getFloodgateApi() {
        return null;
    }
    
    private final void loadConfig() {
    }
    
    @com.velocitypowered.api.event.Subscribe()
    public final void onProxyInitialization(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.proxy.ProxyInitializeEvent event) {
    }
    
    @com.velocitypowered.api.event.Subscribe()
    public final void onProxyShutdown(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.proxy.ProxyShutdownEvent event) {
    }
    
    private final void startManagers() {
    }
    
    private final void registerCommands() {
    }
}