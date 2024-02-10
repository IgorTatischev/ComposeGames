package com.game.lightsout.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object Game : Screens(
        route = "game_lightsOff/{level}",
        arguments = listOf(
            navArgument(name = "level") {
                type = NavType.IntType
                defaultValue = -1
            },
        )
    ) {
        fun navigateToGame(level: Int) = "game_lightsOff/$level"
    }

    object Menu : Screens(
        route = "menu_lightsOff"
    )

    object Score : Screens(
        route = "score_lightsOff/{turns}/{level}/{win}",
        arguments = listOf(
            navArgument(name = "turns") {
                type = NavType.IntType
                defaultValue = -1
            },
            navArgument(name = "level") {
                type = NavType.IntType
                defaultValue = -1
            },
            navArgument(name = "win") {
                type = NavType.BoolType
                defaultValue = false
            },
        )
    ) {
        fun navigateToScore(turns: Int, level: Int, win: Boolean) = "score_lightsOff/$turns/$level/$win"
    }
}