package com.doodler.jumper.game.screens.menu_screen

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.doodler.jumper.R
import com.doodler.jumper.game.components.MenuButton
import com.doodler.jumper.navigation.Screens
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(viewModel: MenuViewModel = koinViewModel(), navController: NavHostController) {

    val context = LocalContext.current
    LaunchedEffect(key1 = Unit) {
        val activity = context as Activity
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val score = viewModel.readScore.collectAsStateWithLifecycle()
        Text(
            text = stringResource(id = R.string.record, score.value),
            fontSize = MaterialTheme.typography.headlineMedium.fontSize
        )
        Spacer(modifier = Modifier.height(30.dp))
        MenuButton(icon = Icons.Filled.PlayArrow, text = stringResource(id = R.string.play)) {
            navController.navigate(Screens.Game.route)
        }
    }
}