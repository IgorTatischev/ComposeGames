package com.cardgame.memorycard.game.screens.game_screen

import com.cardgame.memorycard.game.util.CardModel

data class GameScreenState(
    val running: GameState = GameState.Game,
    val list: List<CardModel> = emptyList(),
    val turns: Long = 0,
)

sealed class GameState {
    object Game: GameState()
    object Score: GameState()
}