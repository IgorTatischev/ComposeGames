package com.example.tictactoequick.presentation.game_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tictactoequick.R
import com.example.tictactoequick.presentation.components.BoardBase
import com.example.tictactoequick.presentation.components.Circle
import com.example.tictactoequick.presentation.components.Cross
import com.example.tictactoequick.presentation.components.ScoreRow
import com.example.tictactoequick.presentation.components.TurnText
import com.example.tictactoequick.presentation.ui.theme.GrayBackground

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel(),
) {

    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TurnText(state.currentTurn)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(GrayBackground),
            contentAlignment = Alignment.Center
        ) {
            BoardBase()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)
            ) {
                viewModel.boardItems.forEach { (cellNumber, cellValue) ->
                    gridItem(
                        cellValue = cellValue,
                        visible = viewModel.boardItems[cellNumber] != BoardCellValue.NONE,
                        onItemClick = {
                            viewModel.onAction(GameEvent.BoardTapped(cellNumber))
                        }
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScoreRow(state)
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                modifier = Modifier.size(height = 70.dp, width = 200.dp),
                onClick = {
                    viewModel.onAction(
                        GameEvent.RestartButtonClicked
                    )
                },
                elevation = ButtonDefaults.buttonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = stringResource(id = R.string.new_game),
                    fontSize = 16.sp
                )
            }

        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun LazyGridScope.gridItem(
    cellValue: BoardCellValue,
    visible: Boolean,
    onItemClick: () -> Unit,
) {
    item {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) { onItemClick() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = scaleIn(tween(500))
            ) {
                if (cellValue == BoardCellValue.CIRCLE) {
                    Circle()
                } else if (cellValue == BoardCellValue.CROSS) {
                    Cross()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GamePreview() {
    GameScreen()
}