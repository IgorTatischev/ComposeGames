package com.doodler.jumper.game.screens.game_screen

import com.doodler.jumper.game.entities.Platform
import com.doodler.jumper.game.entities.Player
import com.doodler.jumper.game.entities.Pot


data class GameScreenState(
    val running: GameState = GameState.Game,
    val score: Long = 0,
    val player: Player = Player(),
    val platforms: List<Platform> = listOf(),
    val pot: Pot = Pot(),
    val time: Long = System.currentTimeMillis(),
)

sealed class GameState {
    object Game: GameState()
    object Score: GameState()
}