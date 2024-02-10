package com.example.tictactoequick.presentation.game_screen

data class GameState(
    val playerCircleCount: Int = 0,
    val playerCrossCount: Int = 0,
    val drawCount: Int = 0,
    val currentTurn: CurrentTurn = CurrentTurn.TURN_O,
    val currentValue: BoardCellValue = BoardCellValue.CIRCLE,
    val isWin: Boolean = false
)

enum class BoardCellValue {
    CIRCLE,
    CROSS,
    NONE
}

enum class CurrentTurn {
    TURN_X,
    TURN_O,
    WIN_X,
    WIN_O,
    DRAW
}

