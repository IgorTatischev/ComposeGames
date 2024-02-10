package com.cardgame.memorycard.game.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cardgame.memorycard.game.screens.game_screen.GameViewModel
import com.cardgame.memorycard.game.util.CardModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(plane: CardModel, gameViewModel: GameViewModel = koinViewModel()) {

    val select = plane.isSelect
    val visible = plane.isVisible

    val rotation by animateFloatAsState(
        targetValue = if (select) 180f else 0f,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing),
        label = "",
    )

    val color by animateColorAsState(
        targetValue = Color.Transparent.copy(alpha = if (select) 1F else 0.0F),
        animationSpec = tween(durationMillis = 400, easing = Ease),
        label = ""
    )


    Card(
        modifier = Modifier
            .padding(10.dp)
            .graphicsLayer { rotationY = rotation }
            .alpha(if (!visible) 0F else 1F)
            .size(150.dp),
        enabled = !select && visible,
        onClick = {
            if (visible) {
                gameViewModel.updateShowVisibleCard(plane.id)
            }
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.Red.copy(alpha = if (visible) 0.5F else 0F),
        ),
        border =
            if (select)
                CardDefaults.outlinedCardBorder(true)
            else
                BorderStroke(0.dp, Color.Transparent),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (select) {
                Text(
                    text = plane.char,
                    fontSize = 32.sp,
                    color = color,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}