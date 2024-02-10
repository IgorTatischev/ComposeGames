package com.game.lightsout.presentation.screens.menu_screen

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.game.lightsout.navigation.Screens
import com.game.ligtsout.R

@Composable
fun MenuScreen(navController: NavHostController) {

    val context = LocalContext.current
    LaunchedEffect(key1 = Unit) {
        val activity = context as Activity
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.size(width = 140.dp, height = 70.dp),
            onClick = { navController.navigate(Screens.Game.navigateToGame(3)) }
        ) {
            Text(text = stringResource(id = R.string.easy))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.size(width = 140.dp, height = 70.dp),
            onClick ={ navController.navigate(Screens.Game.navigateToGame(4)) }
        ) {
            Text(text = stringResource(id = R.string.medium))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.size(width = 140.dp, height = 70.dp),
            onClick = { navController.navigate(Screens.Game.navigateToGame(5)) }
        ) {
            Text(text = stringResource(id = R.string.hard))
        }
    }
}