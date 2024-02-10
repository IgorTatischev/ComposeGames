package com.clicker.aviatorclicker.game.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clicker.aviatorclicker.game.data.model.Item

@Database(
    entities = [Item::class],
    version = 6
)
abstract class GameDatabase: RoomDatabase() {

    abstract val gameDao : GameDao

    companion object{
        const val DATABASE_NAME = "game_db"
    }
}


