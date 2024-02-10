package com.cardgame.memorycard.game.util

import java.util.UUID

data class CardModel(
    var id: String = UUID.randomUUID().toString(),
    var char: String,
    var isVisible: Boolean = true,
    var isSelect: Boolean = false,
)



