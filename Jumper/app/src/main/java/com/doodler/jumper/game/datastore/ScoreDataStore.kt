package com.doodler.jumper.game.datastore

import kotlinx.coroutines.flow.Flow

interface ScoreDataStore {

    val getScore: Flow<Long>

    suspend fun saveScore(score: Long)
}