package com.game.lightsout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.game.lightsout.navigation.Navigation
import com.game.lightsout.ui.theme.LightsOutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LightsOutTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}

