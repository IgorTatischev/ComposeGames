package com.doodler.jumper.game.screens.game_screen

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.doodler.jumper.game.components.Background
import com.doodler.jumper.game.components.GameCanvas
import com.doodler.jumper.game.components.ScoreScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameScreen(gameViewModel: GameViewModel = koinViewModel()) {

    val context = LocalContext.current

    DisposableEffect(key1 = Unit) {
        val activity = context as Activity
        val originalOrientation = activity.requestedOrientation
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        gameViewModel.setRes(context.resources)
        gameViewModel.play()

        onDispose {
            activity.requestedOrientation = originalOrientation
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val state = gameViewModel.state.collectAsState()

        Background()

        when (state.value.running) {

            is GameState.Game -> {
                GameCanvas()
            }

            is GameState.Score -> {
                ScoreScreen(
                    score = state.value.score,
                    onRestart = { gameViewModel.play() }
                )
            }
        }
    }
}