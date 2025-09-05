package com.hariharnautiyal.velocity.h01.models

data class Vault(
    val _id: String,
    val ownerId: String,
    val vaultNumber: Int,
    val items: List<String> = emptyList()
)