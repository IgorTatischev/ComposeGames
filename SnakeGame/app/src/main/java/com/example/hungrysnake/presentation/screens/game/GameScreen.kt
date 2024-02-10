package com.example.hungrysnake.presentation.screens.game

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hungrysnake.presentation.componets.Board
import com.example.hungrysnake.presentation.componets.ControlButtons
import com.example.hungrysnake.presentation.componets.ScoreScreen
import com.example.hungrysnake.presentation.screens.destinations.GameScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo

@Destination
@Composable
fun GameScreen(
    gameViewModel: GameViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
) {

    when(val state = gameViewModel.state.collectAsState().value){

        is GameState.Running -> {
            LaunchedEffect(key1 = Unit) {
                gameViewModel.play()
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Board(state)
                ControlButtons {
                    gameViewModel.direction = it
                }
            }
        }

        is GameState.Score -> {
            ScoreScreen(
                score = state.score,
                onRestart = {
                    navigator.navigate(GameScreenDestination) {
                        popUpTo(GameScreenDestination) { inclusive = true }
                    }
                }
            )
        }
    }
}

