package com.game.lightsout.presentation.screens.game_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.game.lightsout.util.BaseViewModel
import com.game.lightsout.util.LEVEL
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import kotlin.random.Random

class GameViewModel(savedStateHandle: SavedStateHandle) :
    BaseViewModel<GameEvent, GameState, GameSideEffect>(initialState = GameState()) {

    private val random = Random(seed = System.currentTimeMillis())
    private var level = 0

    init {
        savedStateHandle.get<Int>(LEVEL)?.let {
            level = it
            newGame(it)
        }
    }

    override fun dispatch(intent: GameEvent) {
        when (intent) {
            is GameEvent.OnCardClick -> selectLight(intent.row, intent.col)
            is GameEvent.ToExitClick -> post(
                GameSideEffect.NavigateToScore(
                    turns = container.stateFlow.value.turns,
                    size = level
                )
            )
        }
    }

    private fun newGame(size: Int) = intent {
        val temp = MutableList(size) { BooleanArray(size) }

        for (row in temp.indices)
            for (col in temp.indices) {
                temp[row][col] = random.nextBoolean()
            }

        reduce { state.copy(board = mutableStateOf(temp.toList())) }
    }

    private fun selectLight(row: Int, col: Int) = intent {

        val grid = state.board.value.toMutableList()
        grid[row][col] = !grid[row][col]

        if (row > 0) {
            grid[row - 1][col] = !grid[row - 1][col]
        }
        if (row < grid.size - 1) {
            grid[row + 1][col] = !grid[row + 1][col]
        }
        if (col > 0) {
            grid[row][col - 1] = !grid[row][col - 1]
        }
        if (col < grid.size - 1) {
            grid[row][col + 1] = !grid[row][col + 1]
        }
        reduce {
            state.copy(
                board = mutableStateOf(grid.toList()),
                turns = state.turns + 1
            )
        }
        isGameOver()
    }

    private fun isGameOver() = intent {
        var isTrue = 0
        var isFalse = 0
        val grid = state.board.value.toMutableList()
        val elements = grid.size * grid.size
        for (row in grid.indices) {
            for (col in grid.indices) {
                if (grid[row][col]) {
                    isTrue++
                } else
                    isFalse++
            }
        }
        if (isTrue == elements || isFalse == elements) {
            post(
                GameSideEffect.NavigateToScore(
                    turns = state.turns,
                    size = state.board.value.size,
                    isWin = true
                )
            )
        }
    }
}