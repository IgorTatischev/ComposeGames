package com.example.tictactoequick.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.tictactoequick.R
import com.example.tictactoequick.presentation.game_screen.GameState

@Composable
fun ScoreRow(state: GameState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.zero_score, state.playerCircleCount),
            fontSize = 20.sp
        )
        Text(
            text = stringResource(id = R.string.draw_score, state.drawCount),
            fontSize = 20.sp
        )
        Text(
            text = stringResource(id = R.string.cross_score, state.playerCrossCount),
            fontSize = 20.sp
        )
    }
}