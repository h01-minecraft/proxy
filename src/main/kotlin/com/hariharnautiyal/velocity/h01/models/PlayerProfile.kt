package com.hariharnautiyal.velocity.h01.models

import com.google.gson.annotations.SerializedName

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
        val kills: Long = 0,
        val deaths: Long = 0,
        val blockedPlayersFromFriendRequests: MutableList<String> = mutableListOf(),
        val vaultCount: Long = 1, // Number of vaults the player has purchased/unlocked
        val ownedVaultIds: List<String> = emptyList(),
        val redeemedCodes: List<String> = emptyList(),
        val discordId: String? = null
)

data class Link(@SerializedName("discord_uid") val discordUid: String)

data class CLink(val minecraft_playername: String)

enum class Edition(val value: String) {
    JAVA("java"),
    BEDROCK("bedrock")
}
