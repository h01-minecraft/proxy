package com.hariharnautiyal.velocity.h01.models

import net.kyori.adventure.text.format.TextColor

data class Prefix(
    val _id: String,
    val prefixText: String,
    val displayColorHex: String,
    val price: Long,
    val isCustom: Boolean = false,
    val customPricePerChar: Int = 0,
    val maxLength: Int = 15
) {
    val displayColor: TextColor
        get() = TextColor.fromHexString(displayColorHex) ?: TextColor.fromHexString("#FFFFFF")!!

    companion object {
        fun create(
            id: String,
            prefixText: String,
            displayColor: TextColor,
            price: Long,
            isCustom: Boolean = false,
            customPricePerChar: Int = 0,
            maxLength: Int = 15
        ): Prefix {
            return Prefix(
                _id = id,
                prefixText = prefixText,
                displayColorHex = displayColor.asHexString(),
                price = price,
                isCustom = isCustom,
                customPricePerChar = customPricePerChar,
                maxLength = maxLength
            )
        }
    }
}