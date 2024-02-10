package com.game.lightsout.di

import com.game.lightsout.presentation.screens.game_screen.GameViewModel
import com.game.lightsout.presentation.screens.score_screen.ScoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object MainModule {
    operator fun invoke()  = module {
        viewModelOf(::GameViewModel)
        viewModelOf(::ScoreViewModel)
    }
}