package com.clicker.aviatorclicker.game.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.clicker.aviatorclicker.game.data.model.Bonus

@Composable
fun BonusesBottomSheet(bonuses: List<Bonus>) {
    LazyColumn {
        items(bonuses) { bonus ->
            BonusItem(bonus = bonus)
        }
    }
}