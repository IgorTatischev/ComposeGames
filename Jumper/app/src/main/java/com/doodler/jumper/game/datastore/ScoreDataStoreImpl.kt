package com.doodler.jumper.game.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ScoreDataStoreImpl(context: Context) : ScoreDataStore {

    private val scoreDataStore = context.dataStore

    companion object {
        private val Context.dataStore by preferencesDataStore("score")
        val SCORE_KEY = longPreferencesKey("max_score")
    }

    override val getScore: Flow<Long> = scoreDataStore.data.map { preferences ->
        preferences[SCORE_KEY] ?: 0
    }

    override suspend fun saveScore(score: Long) {
        scoreDataStore.edit { preferences ->
            preferences[SCORE_KEY] = score
        }
    }
}