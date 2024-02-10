package com.game.lightsout.presentation.screens.game_screen

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.game.lightsout.navigation.Screens
import com.game.lightsout.presentation.components.GameCanvas
import com.game.ligtsout.R
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(viewModel: GameViewModel = koinViewModel(), navController: NavHostController) {

    val boardState by viewModel.container.stateFlow.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is GameSideEffect.NavigateToScore -> {
                navController.navigate(
                    Screens.Score.navigateToScore(
                        turns = sideEffect.turns,
                        level = sideEffect.size,
                        win = sideEffect.isWin
                    )
                ) {
                    popUpTo(Screens.Menu.route)
                }
            }
        }
    }

    Scaffold(
        topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = R.string.score, boardState.turns),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.End
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { viewModel.dispatch(GameEvent.ToExitClick) },
                        ) {
                            Icon(
                                modifier = Modifier.size(35.dp),
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                )
        },
    ) { padding ->
        GameCanvas(padding = padding)
    }
}