package com.hariharnautiyal.velocity.h01.models

data class PrefixRecord(
    val id: String,
    val text: String,
    val colorHex: String,
    val price: Long = 0L,
)

enum class OpenShopResult {
    SUCCESS,
    ERROR
}