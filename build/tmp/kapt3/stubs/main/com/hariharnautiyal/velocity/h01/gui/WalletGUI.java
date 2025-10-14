package com.hariharnautiyal.velocity.h01.gui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/gui/WalletGUI;", "", "economyManager", "Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;", "floodgateApi", "Lorg/geysermc/floodgate/api/FloodgateApi;", "playerManager", "Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;", "server", "Lcom/velocitypowered/api/proxy/ProxyServer;", "(Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;Lorg/geysermc/floodgate/api/FloodgateApi;Lcom/hariharnautiyal/velocity/h01/managers/PlayerManager;Lcom/velocitypowered/api/proxy/ProxyServer;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "balance", "", "player", "Lcom/velocitypowered/api/proxy/Player;", "", "error", "friendsListForm", "mainMenu", "payAmountForm", "sender", "recipient", "payError", "message", "", "playerNotFound", "transferReceivedGUI", "amount", "h01"})
public final class WalletGUI {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.EconomyManager economyManager = null;
    @org.jetbrains.annotations.NotNull()
    private final org.geysermc.floodgate.api.FloodgateApi floodgateApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.velocitypowered.api.proxy.ProxyServer server = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    public WalletGUI(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.EconomyManager economyManager, @org.jetbrains.annotations.NotNull()
    org.geysermc.floodgate.api.FloodgateApi floodgateApi, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.PlayerManager playerManager, @org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.ProxyServer server) {
        super();
    }
    
    public final void mainMenu(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.Player player) {
    }
    
    private final void friendsListForm(com.velocitypowered.api.proxy.Player player) {
    }
    
    private final void payAmountForm(com.velocitypowered.api.proxy.Player sender, com.velocitypowered.api.proxy.Player recipient) {
    }
    
    public final void balance(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.Player player, long balance) {
    }
    
    public final void playerNotFound(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.Player player) {
    }
    
    public final void error(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.Player player) {
    }
    
    public final void payError(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.Player player, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void transferReceivedGUI(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.Player recipient, @org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.Player sender, long amount) {
    }
}