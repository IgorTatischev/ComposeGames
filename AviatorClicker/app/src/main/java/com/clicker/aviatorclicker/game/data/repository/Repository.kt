package com.clicker.aviatorclicker.game.data.repository

import com.clicker.aviatorclicker.game.data.model.Item
import com.clicker.aviatorclicker.game.data.source.GameDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val dao: GameDao) {

    fun getBonuses(): Flow<List<Item>> = dao.getBonuses().flowOn(Dispatchers.IO)

    suspend fun getBonus(name: String): Item? {
        return dao.getBonus(name)
    }

    suspend fun insertBonus(item: Item) {
        dao.insertBonus(item)
    }
}