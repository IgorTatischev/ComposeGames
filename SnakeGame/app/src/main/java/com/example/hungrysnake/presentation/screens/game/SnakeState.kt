package com.example.hungrysnake.presentation.screens.game

sealed class GameState {

    class Running(
        val food: Pair<Int, Int> = Pair(5, 5),
        val snake: List<Pair<Int, Int>> = listOf(Pair(7, 7)),
    ) : GameState()

    class Score(val score: Long = 0) : GameState()
}