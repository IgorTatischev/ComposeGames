package com.clicker.aviatorclicker.game.data.source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clicker.aviatorclicker.game.data.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM Item")
    fun getBonuses(): Flow<List<Item>>

    @Query("SELECT * FROM Item WHERE name = :name")
    suspend fun getBonus(name: String): Item?

    @Upsert
    suspend fun insertBonus(item: Item)
}