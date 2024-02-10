package com.game.lightsout.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.game.lightsout.presentation.screens.game_screen.GameScreen
import com.game.lightsout.presentation.screens.menu_screen.MenuScreen
import com.game.lightsout.presentation.screens.score_screen.ScoreScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Menu.route
    ) {
        composable(route = Screens.Menu.route) {
            MenuScreen(navController = navController)
        }

        composable(
            route = Screens.Game.route,
            arguments = Screens.Game.arguments
        ) {
            GameScreen(navController = navController)
        }

        composable(
            route = Screens.Score.route,
            arguments = Screens.Score.arguments
        ) {
            ScoreScreen(navigateToMain = { navController.navigate(Screens.Menu.route) })
        }
    }
}