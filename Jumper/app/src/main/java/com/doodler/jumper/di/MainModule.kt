package com.doodler.jumper.di

import com.doodler.jumper.game.datastore.ScoreDataStore
import com.doodler.jumper.game.datastore.ScoreDataStoreImpl
import com.doodler.jumper.game.screens.game_screen.GameViewModel
import com.doodler.jumper.game.screens.menu_screen.MenuViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object MainModule {
    val module = module {
        single <ScoreDataStore>{ ScoreDataStoreImpl(androidApplication()) }
        viewModelOf(::GameViewModel)
        viewModelOf(::MenuViewModel)
    }
}