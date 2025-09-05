package com.hariharnautiyal.velocity.h01.models

data class Team(
    val _id: String,
    val name: String,
    val displayName: String,
    val members: List<String> = emptyList(),
    val leader: String? = null,
    val open: Boolean = false,
    val requestBlocked: Boolean = false,
    val maxSize: Int = 4,
    val bannedPlayers: List<String> = emptyList(),
    val moderators: List<String> = emptyList(),
    val color: String? = null,
)
