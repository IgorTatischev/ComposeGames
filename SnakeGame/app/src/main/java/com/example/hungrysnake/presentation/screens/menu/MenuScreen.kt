package com.example.hungrysnake.presentation.screens.menu

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hungrysnake.R
import com.example.hungrysnake.datastore.ScoreDataStore
import com.example.hungrysnake.presentation.componets.MenuButton
import com.example.hungrysnake.presentation.screens.destinations.GameScreenDestination
import com.example.hungrysnake.presentation.screens.game.GameViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun MenuScreen(navigator: DestinationsNavigator, viewModel: MenuViewModel = hiltViewModel()) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val score = viewModel.readScore.collectAsStateWithLifecycle()
        Text(text = stringResource(id = R.string.last_score, score.value),
            fontSize = MaterialTheme.typography.headlineMedium.fontSize)
        Spacer(modifier = Modifier.height(30.dp))

        MenuButton(text = stringResource(id = R.string.play)) {
            navigator.navigate(GameScreenDestination())
        }
        Spacer(modifier = Modifier.height(30.dp))

        val context = LocalContext.current
        MenuButton(text = stringResource(id = R.string.exit)) {
            context.findActivity()?.finishAndRemoveTask()
        }
    }
}

fun Context.findActivity(): AppCompatActivity? = when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
