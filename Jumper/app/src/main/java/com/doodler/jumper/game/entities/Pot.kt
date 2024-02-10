package com.doodler.jumper.game.entities

import com.doodler.jumper.game.util.Bitmaps
import com.doodler.jumper.game.util.Bitmaps.screenHeight
import kotlin.random.Random

class Pot : GameObject() {

    fun init() {
        bitmap = Bitmaps.pot
        height = bitmap?.height ?: 0
        width = bitmap?.width ?: 0
        x = Random.nextInt(Bitmaps.screenWidth - width).toFloat()
        y = 0 - height.toFloat() - getRandom(screenHeight * 10)
    }

}