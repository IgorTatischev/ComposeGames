package com.doodler.jumper.game.entities

import com.doodler.jumper.game.util.Bitmaps
import com.doodler.jumper.game.util.Bitmaps.screenWidth
import kotlin.random.Random

class Platform : GameObject() {

    init {
        bitmap = Bitmaps.platform
        height = bitmap?.height ?: 0
        width = bitmap?.width ?: 0
        x = Random.nextInt(screenWidth - width).toFloat()
    }

    fun init(y: Float) {
        this.y = y
    }
}