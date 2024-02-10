package com.doodler.jumper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.doodler.jumper.navigation.Navigation
import com.doodler.jumper.ui.theme.JamperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JamperTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}
