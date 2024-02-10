package com.game.lightsout.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.game.lightsout.presentation.screens.game_screen.GameEvent
import com.game.lightsout.presentation.screens.game_screen.GameViewModel
import com.game.ligtsout.R
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCanvas(
    viewModel: GameViewModel = koinViewModel(),
    padding: PaddingValues,
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(padding), contentAlignment = Alignment.Center
    ) {

        val boardState by viewModel.container.stateFlow.collectAsState()
        val board = boardState.board.value

        LazyVerticalGrid(
            columns = GridCells.Fixed(board.size),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            for (col in board.indices) {
                for (row in board.indices) {
                    item {
                        val cellState = remember(boardState.board) { board[col][row] }
                        Card(
                            modifier = Modifier.fillMaxSize().padding(5.dp),
                            elevation = CardDefaults.cardElevation(0.dp),
                            onClick = { viewModel.dispatch(GameEvent.OnCardClick(col, row)) },
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
                        ) {
                            Image(
                                modifier = Modifier.fillMaxWidth().padding(5.dp),
                                painter =
                                if (cellState) painterResource(id = R.drawable.arm1)
                                else painterResource(id = R.drawable.arm2),
                                contentDescription = "",
                                alignment = Alignment.Center,
                                contentScale = ContentScale.FillWidth,
                            )
                        }
                    }
                }
            }
        }
    }
}