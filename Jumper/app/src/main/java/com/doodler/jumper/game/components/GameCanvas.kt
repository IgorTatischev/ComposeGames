package com.doodler.jumper.game.components

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doodler.jumper.game.screens.game_screen.GameViewModel
import com.doodler.jumper.game.util.Bitmaps.screenWidth
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GameCanvas(gameViewModel: GameViewModel = koinViewModel()) {

    val state = gameViewModel.state.collectAsState().value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInteropFilter { event ->
                    when (event.action) {
                        MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                            gameViewModel.changeDirection(event.x)

                            true
                        }

                        MotionEvent.ACTION_UP -> {
                            gameViewModel.stopMovingPlayer()
                            true
                        }

                        else -> false
                    }
                },
        ) {
            val player = state.player

            translate(0f, (screenWidth / 2 - player.y)) {

                if (player.playerDirection > -1) {
                    player.bitmap?.let {
                        drawImage(it, Offset(player.x, player.y))
                    }
                } else {
                    player.playerLeft?.let {
                        drawImage(it, Offset(player.x, player.y))
                    }
                }

                state.platforms.forEach { platform ->
                    platform.bitmap?.let {
                        drawImage(
                            it,
                            Offset(platform.x, platform.y)
                        )
                    }
                }

                state.pot.bitmap?.let { drawImage(it,  Offset(state.pot.x, state.pot.y)) }
            }
        }

        Text(
            text = state.score.toString(),
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 22.sp,
            modifier = Modifier
                .navigationBarsPadding()
                .align(Alignment.TopEnd)
                .padding(top = 16.dp, end = 16.dp)
        )
    }
}