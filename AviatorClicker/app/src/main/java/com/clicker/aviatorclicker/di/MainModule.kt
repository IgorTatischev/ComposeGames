package com.clicker.aviatorclicker.di

import androidx.room.Room
import com.clicker.aviatorclicker.game.data.repository.Repository
import com.clicker.aviatorclicker.game.data.source.GameDatabase
import com.clicker.aviatorclicker.game.data.source.GameDatabase.Companion.DATABASE_NAME
import com.clicker.aviatorclicker.game.data.source.PreLoadDatabase
import com.clicker.aviatorclicker.game.datastore.ScoreDataStore
import com.clicker.aviatorclicker.game.game_screen.GameViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object MainModule {
    val module = module {

        single {
            Room.databaseBuilder(get(), GameDatabase::class.java, DATABASE_NAME)
                .addCallback(callback = PreLoadDatabase())
                .build()
        }
        single { get<GameDatabase>().gameDao }
        single { Repository(dao = get()) }

        single { ScoreDataStore(context = androidApplication()) }
        viewModelOf(::GameViewModel)
    }
}