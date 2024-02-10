package com.clicker.aviatorclicker.game.game_screen

import com.clicker.aviatorclicker.game.data.model.Bonus

data class GameState(
    val score: Long = 0,
    val bonuses: List<Bonus> = emptyList(),
)
