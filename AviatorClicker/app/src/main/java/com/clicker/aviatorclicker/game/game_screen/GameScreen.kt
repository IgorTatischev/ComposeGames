package com.clicker.aviatorclicker.game.game_screen

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.clicker.aviatorclicker.game.components.BonusesBottomSheet
import com.clicker.aviatorclicker.game.components.GameTopAppBar
import com.clicker.aviatorclicker.R
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(gameViewModel: GameViewModel = koinViewModel()) {

    val context = LocalContext.current
    val state = gameViewModel.state.collectAsState().value

    LaunchedEffect(key1 = true){
        gameViewModel.play()
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.background),
        contentDescription = "background",
        contentScale = ContentScale.FillBounds
    )

    BottomSheetScaffold(
        topBar = { GameTopAppBar(state.score) },
        sheetContent = { BonusesBottomSheet(state.bonuses) },
        containerColor = Color.Transparent
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        val scale by animateFloatAsState(targetValue = if (isPressed) 0.9f else 1f, label = "scale")

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .size(400.dp)
                    .align(Alignment.Center)
                    .padding(20.dp)
                    .scale(scale)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        gameViewModel.addScore()
                    },
                painter = painterResource(id = R.drawable.aircraft),
                contentDescription = "click"
            )
        }
    }

    DisposableEffect(key1 = Unit) {
        val activity = context as Activity
        val originalOrientation = activity.requestedOrientation
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        onDispose {
            activity.requestedOrientation = originalOrientation
        }
    }
}