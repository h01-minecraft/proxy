package com.hariharnautiyal.velocity.h01.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00c3\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\u0002\u0010#J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u00c6\u0003J\t\u0010F\u001a\u00020\u0007H\u00c6\u0003J\t\u0010G\u001a\u00020\u0013H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u0013H\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000fH\u00c6\u0003J\t\u0010Q\u001a\u00020\u0007H\u00c6\u0003J\t\u0010R\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u00c6\u0003J\t\u0010T\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\t\u0010W\u001a\u00020\u0007H\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u00c6\u0003J\u00cb\u0002\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010 \u001a\u00020\u00072\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0001J\u0013\u0010_\u001a\u00020\u00132\b\u0010`\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010a\u001a\u00020bH\u00d6\u0001J\t\u0010c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u001a\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u00100R\u0011\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010*\"\u0004\b3\u00104R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0011\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010%R\u0011\u0010 \u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010*\u00a8\u0006d"}, d2 = {"Lcom/hariharnautiyal/velocity/h01/models/PlayerProfile;", "", "_id", "", "edition", "Lcom/hariharnautiyal/velocity/h01/models/Edition;", "coins", "", "playerName", "prefixes", "", "selectedPrefix", "teamId", "friends", "pendingIncomingRequests", "", "pendingOutgoingRequests", "lastUpdated", "invitesBlocked", "", "registeredIP", "registrationTime", "authProvider", "providerId", "providerUsername", "providerEmail", "isVerified", "linkedAccounts", "Lcom/hariharnautiyal/velocity/h01/models/LinkedAccount;", "kills", "deaths", "blockedPlayersFromFriendRequests", "vaultCount", "ownedVaultIds", "redeemedCodes", "(Ljava/lang/String;Lcom/hariharnautiyal/velocity/h01/models/Edition;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;JJLjava/util/List;JLjava/util/List;Ljava/util/List;)V", "get_id", "()Ljava/lang/String;", "getAuthProvider", "getBlockedPlayersFromFriendRequests", "()Ljava/util/List;", "getCoins", "()J", "getDeaths", "getEdition", "()Lcom/hariharnautiyal/velocity/h01/models/Edition;", "getFriends", "getInvitesBlocked", "()Z", "getKills", "getLastUpdated", "setLastUpdated", "(J)V", "getLinkedAccounts", "getOwnedVaultIds", "getPendingIncomingRequests", "getPendingOutgoingRequests", "getPlayerName", "getPrefixes", "getProviderEmail", "getProviderId", "getProviderUsername", "getRedeemedCodes", "getRegisteredIP", "getRegistrationTime", "getSelectedPrefix", "getTeamId", "getVaultCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "h01"})
public final class PlayerProfile {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String _id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hariharnautiyal.velocity.h01.models.Edition edition = null;
    private final long coins = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String playerName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> prefixes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String selectedPrefix = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String teamId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> friends = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> pendingIncomingRequests = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> pendingOutgoingRequests = null;
    private long lastUpdated;
    private final boolean invitesBlocked = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String registeredIP = null;
    private final long registrationTime = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String authProvider = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String providerId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String providerUsername = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String providerEmail = null;
    private final boolean isVerified = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hariharnautiyal.velocity.h01.models.LinkedAccount> linkedAccounts = null;
    private final long kills = 0L;
    private final long deaths = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> blockedPlayersFromFriendRequests = null;
    private final long vaultCount = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> ownedVaultIds = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> redeemedCodes = null;
    
    public PlayerProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String _id, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.Edition edition, long coins, @org.jetbrains.annotations.NotNull()
    java.lang.String playerName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> prefixes, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedPrefix, @org.jetbrains.annotations.Nullable()
    java.lang.String teamId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> friends, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> pendingIncomingRequests, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> pendingOutgoingRequests, long lastUpdated, boolean invitesBlocked, @org.jetbrains.annotations.Nullable()
    java.lang.String registeredIP, long registrationTime, @org.jetbrains.annotations.Nullable()
    java.lang.String authProvider, @org.jetbrains.annotations.Nullable()
    java.lang.String providerId, @org.jetbrains.annotations.Nullable()
    java.lang.String providerUsername, @org.jetbrains.annotations.Nullable()
    java.lang.String providerEmail, boolean isVerified, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hariharnautiyal.velocity.h01.models.LinkedAccount> linkedAccounts, long kills, long deaths, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedPlayersFromFriendRequests, long vaultCount, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> ownedVaultIds, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> redeemedCodes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String get_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hariharnautiyal.velocity.h01.models.Edition getEdition() {
        return null;
    }
    
    public final long getCoins() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlayerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPrefixes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedPrefix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTeamId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getFriends() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPendingIncomingRequests() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPendingOutgoingRequests() {
        return null;
    }
    
    public final long getLastUpdated() {
        return 0L;
    }
    
    public final void setLastUpdated(long p0) {
    }
    
    public final boolean getInvitesBlocked() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRegisteredIP() {
        return null;
    }
    
    public final long getRegistrationTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAuthProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProviderId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProviderUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProviderEmail() {
        return null;
    }
    
    public final boolean isVerified() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hariharnautiyal.velocity.h01.models.LinkedAccount> getLinkedAccounts() {
        return null;
    }
    
    public final long getKills() {
        return 0L;
    }
    
    public final long getDeaths() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBlockedPlayersFromFriendRequests() {
        return null;
    }
    
    public final long getVaultCount() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getOwnedVaultIds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRedeemedCodes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    public final long component14() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hariharnautiyal.velocity.h01.models.Edition component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hariharnautiyal.velocity.h01.models.LinkedAccount> component20() {
        return null;
    }
    
    public final long component21() {
        return 0L;
    }
    
    public final long component22() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component23() {
        return null;
    }
    
    public final long component24() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component26() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hariharnautiyal.velocity.h01.models.PlayerProfile copy(@org.jetbrains.annotations.NotNull()
    java.lang.String _id, @org.jetbrains.annotations.NotNull()
    com.hariharnautiyal.velocity.h01.models.Edition edition, long coins, @org.jetbrains.annotations.NotNull()
    java.lang.String playerName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> prefixes, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedPrefix, @org.jetbrains.annotations.Nullable()
    java.lang.String teamId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> friends, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> pendingIncomingRequests, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> pendingOutgoingRequests, long lastUpdated, boolean invitesBlocked, @org.jetbrains.annotations.Nullable()
    java.lang.String registeredIP, long registrationTime, @org.jetbrains.annotations.Nullable()
    java.lang.String authProvider, @org.jetbrains.annotations.Nullable()
    java.lang.String providerId, @org.jetbrains.annotations.Nullable()
    java.lang.String providerUsername, @org.jetbrains.annotations.Nullable()
    java.lang.String providerEmail, boolean isVerified, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hariharnautiyal.velocity.h01.models.LinkedAccount> linkedAccounts, long kills, long deaths, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedPlayersFromFriendRequests, long vaultCount, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> ownedVaultIds, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> redeemedCodes) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}