package com.example.shoping

data class CardItem(val name: String, val cardnum: String) {
    fun getMaskedCardNumber(): String {
        return if (cardnum.length >= 12) {
            val last4Digits = cardnum.takeLast(4)
            val maskedDigits = "*".repeat(cardnum.length - 4)
            "$maskedDigits$last4Digits"
        } else {
            cardnum
        }
    }
}