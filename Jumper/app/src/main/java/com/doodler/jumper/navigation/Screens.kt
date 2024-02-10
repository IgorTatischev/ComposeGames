package com.doodler.jumper.navigation


sealed class Screens(val route: String) {

    object Game : Screens(
        route = "game"
    )

    object Menu : Screens(
        route = "menu"
    )
}
