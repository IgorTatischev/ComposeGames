package com.doodler.jumper.game.entities

import androidx.compose.ui.graphics.ImageBitmap
import com.doodler.jumper.game.util.Bitmaps

class Player: GameObject() {

    var playerDirection: Int = 0
    var speed: Float = 10f
    var velocity = 0.0f
    val gravity = 0.1f
    val jumpForce = 18f
    var playerLeft: ImageBitmap? = null

    fun init() {
        bitmap = Bitmaps.player
        playerLeft = Bitmaps.playerLeft
        height = bitmap?.height ?: 0
        width = bitmap?.width ?: 0
        x = width / 2f
        y = height / 2f
    }
}