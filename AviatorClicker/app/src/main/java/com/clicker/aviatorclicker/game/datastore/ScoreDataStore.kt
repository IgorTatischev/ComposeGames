package com.clicker.aviatorclicker.game.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("score")

class ScoreDataStore(context: Context) {

    private val scoreDataStore = context.dataStore

    companion object {
        val SCORE_KEY = longPreferencesKey("score")
    }

    val getScore: Flow<Long> = scoreDataStore.data.map { preferences ->
        preferences[SCORE_KEY] ?: 0
    }

    suspend fun saveScore(score: Long) {
        scoreDataStore.edit { preferences ->
            preferences[SCORE_KEY] = score
        }
    }
}