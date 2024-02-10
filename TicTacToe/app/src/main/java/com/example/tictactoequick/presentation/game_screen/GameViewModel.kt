package com.example.tictactoequick.presentation.game_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(GameState())

    val boardItems: MutableMap<Int, BoardCellValue> = mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE,
    )

    fun onAction(action: GameEvent) {
        when (action) {
            is GameEvent.BoardTapped -> {
                addValueToBoard(action.cellNumber)
            }

            GameEvent.RestartButtonClicked -> {
                gameReset()
            }
        }
    }

    private fun gameReset() {
        boardItems.forEach { (i, _) ->
            boardItems[i] = BoardCellValue.NONE
        }
        state = state.copy(
            currentValue = BoardCellValue.CIRCLE,
            currentTurn = CurrentTurn.TURN_O,
            isWin = false
        )
    }

    private fun addValueToBoard(cellNumber: Int) {
        if (boardItems[cellNumber] != BoardCellValue.NONE) {
            return
        }

        when (state.currentValue) {
            BoardCellValue.CIRCLE -> {
                boardItems[cellNumber] = BoardCellValue.CIRCLE
                if (checkForVictory(BoardCellValue.CIRCLE)) {
                    state = state.copy(
                        currentTurn = CurrentTurn.WIN_O,
                        playerCircleCount = state.playerCircleCount + 1,
                        currentValue = BoardCellValue.NONE,
                        isWin = true
                    )
                } else if (hasBoardFull()) {
                    state = state.copy(
                        currentTurn = CurrentTurn.DRAW,
                        drawCount = state.drawCount + 1
                    )
                } else {
                    state = state.copy(
                        currentTurn = CurrentTurn.TURN_X,
                        currentValue = BoardCellValue.CROSS
                    )
                }
            }

            BoardCellValue.CROSS -> {
                boardItems[cellNumber] = BoardCellValue.CROSS
                if (checkForVictory(BoardCellValue.CROSS)) {
                    state = state.copy(
                        currentTurn = CurrentTurn.WIN_X,
                        playerCrossCount = state.playerCrossCount + 1,
                        currentValue = BoardCellValue.NONE,
                        isWin = true
                    )
                } else if (hasBoardFull()) {
                    state = state.copy(
                        currentTurn = CurrentTurn.DRAW,
                        drawCount = state.drawCount + 1
                    )
                } else {
                    state = state.copy(
                        currentTurn = CurrentTurn.TURN_O,
                        currentValue = BoardCellValue.CIRCLE
                    )
                }
            }

            BoardCellValue.NONE -> { }
        }
    }

    private fun checkForVictory(boardValue: BoardCellValue): Boolean {
        return when {
            boardItems[1] == boardValue && boardItems[2] == boardValue && boardItems[3] == boardValue -> true
            boardItems[4] == boardValue && boardItems[5] == boardValue && boardItems[6] == boardValue -> true
            boardItems[7] == boardValue && boardItems[8] == boardValue && boardItems[9] == boardValue -> true
            boardItems[1] == boardValue && boardItems[4] == boardValue && boardItems[7] == boardValue -> true
            boardItems[2] == boardValue && boardItems[5] == boardValue && boardItems[8] == boardValue -> true
            boardItems[3] == boardValue && boardItems[6] == boardValue && boardItems[9] == boardValue -> true
            boardItems[1] == boardValue && boardItems[5] == boardValue && boardItems[9] == boardValue -> true
            boardItems[3] == boardValue && boardItems[5] == boardValue && boardItems[7] == boardValue -> true
            else -> false
        }
    }

    private fun hasBoardFull(): Boolean {
        if (boardItems.containsValue(BoardCellValue.NONE)) return false
        return true
    }
}