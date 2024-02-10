package com.doodler.jumper.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.doodler.jumper.game.screens.game_screen.GameScreen
import com.doodler.jumper.game.screens.menu_screen.MenuScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Menu.route
    ) {
        composable(route = Screens.Menu.route) {
            MenuScreen(navController = navController)
        }
        composable(route = Screens.Game.route) {
            GameScreen()
        }
    }
}