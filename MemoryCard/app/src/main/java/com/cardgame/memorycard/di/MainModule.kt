package com.cardgame.memorycard.di

import com.cardgame.memorycard.game.screens.game_screen.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object MainModule {
    val module = module {
        viewModelOf(::GameViewModel)
    }
}