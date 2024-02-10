package com.example.tictactoequick.presentation.main_activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.tictactoequick.presentation.game_screen.GameScreen
import com.example.tictactoequick.presentation.ui.theme.TicTacToeQuickTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            TicTacToeQuickTheme {
                GameScreen()
            }
        }
    }
}
