package com.hariharnautiyal.velocity.h01.commands;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/commands/BalanceCommand;", "Lcom/velocitypowered/api/command/SimpleCommand;", "economyManager", "Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;", "server", "Lcom/velocitypowered/api/proxy/ProxyServer;", "floodgateApi", "Lorg/geysermc/floodgate/api/FloodgateApi;", "walletGUI", "Lcom/hariharnautiyal/velocity/h01/gui/WalletGUI;", "(Lcom/hariharnautiyal/velocity/h01/managers/EconomyManager;Lcom/velocitypowered/api/proxy/ProxyServer;Lorg/geysermc/floodgate/api/FloodgateApi;Lcom/hariharnautiyal/velocity/h01/gui/WalletGUI;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "execute", "", "invocation", "Lcom/velocitypowered/api/command/SimpleCommand$Invocation;", "handleCommand", "player", "Lcom/velocitypowered/api/proxy/Player;", "hasPermission", "", "sendUsage", "h01"})
public final class BalanceCommand implements com.velocitypowered.api.command.SimpleCommand {
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.managers.EconomyManager economyManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.velocitypowered.api.proxy.ProxyServer server = null;
    @org.jetbrains.annotations.NotNull()
    private final org.geysermc.floodgate.api.FloodgateApi floodgateApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.gui.WalletGUI walletGUI = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    public BalanceCommand(@org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.managers.EconomyManager economyManager, @org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.ProxyServer server, @org.jetbrains.annotations.NotNull()
    org.geysermc.floodgate.api.FloodgateApi floodgateApi, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.gui.WalletGUI walletGUI) {
        super();
    }
    
    @java.lang.Override()
    public void execute(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.command.SimpleCommand.Invocation invocation) {
    }
    
    private final void handleCommand(com.velocitypowered.api.proxy.Player player) {
    }
    
    private final void sendUsage(com.velocitypowered.api.proxy.Player player) {
    }
    
    @java.lang.Override()
    public boolean hasPermission(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.command.SimpleCommand.Invocation invocation) {
        return false;
    }
}