package com.clicker.aviatorclicker.game.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.clicker.aviatorclicker.game.data.model.Bonus
import com.clicker.aviatorclicker.game.game_screen.GameViewModel
import com.clicker.aviatorclicker.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun BonusItem(gameViewModel: GameViewModel = koinViewModel(), bonus: Bonus) {

    val price = (bonus.count * bonus.bonusItem.priceRatio + bonus.bonusItem.startPrice).toLong()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .weight(weight = 2f, fill = false),
            painter = painterResource(id = bonus.bonusItem.resId),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp),
            text = stringResource(id = R.string.count, bonus.count)
        )

        Row(Modifier.weight(1f)) {
            Text(text = price.toString())
            Image(
                modifier = Modifier
                    .size(20.dp)
                    .padding(start = 5.dp),
                painter = painterResource(id = R.drawable.aircraft),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }

        Button(
            modifier = Modifier.weight(weight = 2f, fill = false),
            onClick = { gameViewModel.buyBonus(bonus.bonusItem , price) }
        ) {
            Text(text = stringResource(id = R.string.buy))
        }
    }
}