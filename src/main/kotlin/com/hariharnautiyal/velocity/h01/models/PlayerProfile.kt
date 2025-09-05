package com.hariharnautiyal.velocity.h01.models

data class PlayerProfile(
    val _id: String,
    val edition: Edition = Edition.JAVA,
    val coins: Long = 0,
    val playerName: String,
    val prefixes: List<String> = emptyList(),
    val selectedPrefix: String? = null,
    val teamId: String? = null,
    val friends: List<String> = emptyList(),
    val pendingIncomingRequests: MutableList<String> = mutableListOf(),
    val pendingOutgoingRequests: MutableList<String> = mutableListOf(),
    var lastUpdated: Long = System.currentTimeMillis(),
    val invitesBlocked: Boolean = false,
    val registeredIP: String? = null,
    val registrationTime: Long = System.currentTimeMillis(),
    val authProvider: String? = null, // "discord", "google", null for bedrock
    val providerId: String? = null, // Unique ID from the provider
    val providerUsername: String? = null, // Username from provider (discord username, google email, etc.)
    val providerEmail: String? = null, // Email from provider
    val isVerified: Boolean = false, // Whether the account is verified
    val linkedAccounts: MutableList<LinkedAccount> = mutableListOf(),
    val kills: Long = 0,
    val deaths: Long = 0,
    val blockedPlayersFromFriendRequests: MutableList<String> = mutableListOf(),
    val vaultCount: Long = 1, // Number of vaults the player has purchased/unlocked
    val ownedVaultIds: List<String> = emptyList(),
    val redeemedCodes: List<String> = emptyList()
)

data class LinkedAccount(
    val provider: String,
    val providerId: String,
    val providerUsername: String? = null,
    val providerEmail: String? = null,
    val linkedAt: Long = System.currentTimeMillis(),
    val profileImage: String? = null,
)

enum class Edition(val value: String) {
    JAVA("java"),
    BEDROCK("bedrock")
}

