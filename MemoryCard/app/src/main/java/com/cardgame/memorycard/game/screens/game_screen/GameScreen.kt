package com.cardgame.memorycard.game.screens.game_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cardgame.memorycard.game.components.GameCanvas
import com.cardgame.memorycard.game.components.ScoreScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameScreen(gameViewModel: GameViewModel = koinViewModel()) {

    val state = gameViewModel.state.value
    val turns = state.turns / 2

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        when (state.running) {

            is GameState.Game -> {
                GameCanvas(
                    cards = state.list,
                    turns = turns,
                    onRestart = { gameViewModel.loadCards() })
            }

            is GameState.Score -> {
                ScoreScreen(
                    score = turns,
                    onRestart = { gameViewModel.loadCards() }
                )
            }
        }
    }
}

