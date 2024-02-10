package com.example.hungrysnake.presentation.main_activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.hungrysnake.presentation.screens.NavGraphs
import com.example.hungrysnake.presentation.ui.theme.HungrySnakeTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HungrySnakeTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
