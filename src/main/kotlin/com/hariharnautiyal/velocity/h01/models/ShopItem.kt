package com.hariharnautiyal.velocity.h01.models

import net.kyori.adventure.text.format.TextColor

data class ShopItem(
    val _id: String,
    val name: String,
    val price: Long,
    val type: String,
    val categoryId: String,
    val buyPrice: Long = 0L,
    val sellPrice: Long = 0L,
)