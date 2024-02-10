package com.example.tictactoequick.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.example.tictactoequick.R
import com.example.tictactoequick.presentation.game_screen.CurrentTurn

@Composable
fun TurnText(currentTurn: CurrentTurn) {
    Text(
        text = when (currentTurn) {
            CurrentTurn.TURN_X -> stringResource(id = R.string.cross_turn)
            CurrentTurn.TURN_O -> stringResource(id = R.string.zero_turn)
            CurrentTurn.WIN_X -> stringResource(id = R.string.cross_win)
            CurrentTurn.WIN_O -> stringResource(id = R.string.zero_win)
            CurrentTurn.DRAW -> stringResource(id = R.string.draw)
        },
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic
    )
}