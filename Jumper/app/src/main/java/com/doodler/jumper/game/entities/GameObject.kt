package com.doodler.jumper.game.entities

import android.graphics.Rect
import androidx.compose.ui.graphics.ImageBitmap
import kotlin.random.Random

open class GameObject {

    var x: Float = 0f
    var y: Float = 0f
    var bitmap: ImageBitmap? = null
    var width: Int = 0
    var height: Int = 0

    private var rect: Rect = Rect()
    open fun setRect() { rect.set(x.toInt(), y.toInt(), (x + width).toInt(), (y + height).toInt()) }

    open fun hasCollision(gameObject: GameObject) = rect.intersects(gameObject.rect)

    fun getRandom(bound: Int) = Random.nextInt(0, bound)
}

fun Rect.intersects(rect: Rect): Boolean {
    return intersects(rect.left, rect.top, rect.right, rect.bottom)
}

