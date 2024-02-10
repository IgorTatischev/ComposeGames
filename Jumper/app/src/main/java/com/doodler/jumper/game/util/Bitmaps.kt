package com.doodler.jumper.game.util

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.doodler.jumper.R

object Bitmaps {

    private var res: Resources? = null

    val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    private const val INIT_WIDTH = 1080
    private const val INIT_HEIGHT = 2040

    private fun resizeWidth(size: Int) = screenWidth * size / INIT_WIDTH
    private fun resizeHeight(size: Int) = screenHeight * size / INIT_HEIGHT

    private val playerWidth = resizeWidth(180)
    private val playerHeight = resizeHeight(180)

    private val potWidth = resizeWidth(150)
    private val potHeight = resizeHeight(150)

    private val platformWidth = resizeWidth(200)
    private val platformHeight = resizeHeight(50)

    val player: ImageBitmap by lazy { initBitmap(R.drawable.leprechaun, playerWidth, playerHeight) }
    val playerLeft: ImageBitmap by lazy { initBitmap(R.drawable.leprechaun_left, playerWidth, playerHeight) }
    val platform: ImageBitmap by lazy { initBitmap(R.drawable.platform, platformWidth, platformHeight) }
    val pot: ImageBitmap by lazy { initBitmap(R.drawable.pot, potWidth, potHeight) }

    fun initialize(resources: Resources) {
        res = resources
    }

    private fun initBitmap(
        @DrawableRes res: Int,
        width: Int,
        height: Int
    ): ImageBitmap {
        return Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(Bitmaps.res, res),
            width,
            height,
            false
        ).asImageBitmap()
    }
}