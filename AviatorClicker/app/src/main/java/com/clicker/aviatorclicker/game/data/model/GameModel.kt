package com.clicker.aviatorclicker.game.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clicker.aviatorclicker.R

@Entity
data class Item(
    @PrimaryKey
    val name: String = BonusItems.Chassis.name,
    val count: Long = 0,
)

data class Bonus(
    val bonusItem: BonusItems,
    val count: Long = 0
)

enum class BonusItems(
    val resId: Int,
    val ratio: Float,
    val priceRatio: Float,
    val startPrice: Long,
) {
    Chassis(R.drawable.chassis, 1f, 50f, 100),
    Rudder(R.drawable.rudder, 5f, 100f, 300),
    Screws(R.drawable.screws, 10f, 150f, 1000),
    Propeller(R.drawable.propeller, 25f, 250f, 5000),
    Engine(R.drawable.engine, 100f, 500f, 10000);
}