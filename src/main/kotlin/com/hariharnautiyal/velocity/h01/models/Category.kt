package com.hariharnautiyal.velocity.h01.models

import net.kyori.adventure.text.format.TextColor

data class Category(
    val _id: String,
    val name: String,
    val displayItem: String,
    val colorHex: String,
    val iconUrl: String? = null,
) {
    val displayColor: TextColor
        get() = TextColor.fromHexString(colorHex) ?: TextColor.fromHexString("#FFFFFF")!!

    companion object {
        fun create(
            id: String,
            name: String,
            displayItem: String,
            color: TextColor,
            iconUrl: String? = null,
        ): Category {
            return Category(
                _id = id,
                name = name,
                displayItem = displayItem,
                colorHex = color.asHexString(),
                iconUrl = iconUrl
            )
        }
    }
}