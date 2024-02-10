package com.example.tictactoequick.presentation.game_screen

sealed class GameEvent {
    object RestartButtonClicked: GameEvent()
    data class BoardTapped(val cellNumber: Int): GameEvent()
}