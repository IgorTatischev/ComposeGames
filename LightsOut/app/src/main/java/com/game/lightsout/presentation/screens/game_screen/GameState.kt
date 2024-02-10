package com.game.lightsout.presentation.screens.game_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.game.lightsout.util.UiEffect
import com.game.lightsout.util.UiIntent

data class GameState(
    val board: MutableState<List<BooleanArray>> = mutableStateOf(emptyList()),
    val turns: Int = 0,
)

sealed interface GameEvent : UiIntent {
    data class OnCardClick(val row: Int, val col: Int) : GameEvent
    object ToExitClick : GameEvent
}

sealed class GameSideEffect : UiEffect {
    data class NavigateToScore(val turns: Int, val size: Int, val isWin: Boolean = false) :
        GameSideEffect()
}