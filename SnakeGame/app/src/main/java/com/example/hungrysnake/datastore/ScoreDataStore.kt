package com.example.hungrysnake.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


private val Context.dataStore by preferencesDataStore("score")

class ScoreDataStore @Inject constructor(@ApplicationContext context: Context) {

    private val scoreDataStore = context.dataStore

    companion object {
        val SCORE_KEY = intPreferencesKey("last_score")
    }

    val getScore: Flow<Int> = scoreDataStore.data.map { preferences ->
        preferences[SCORE_KEY] ?: 0
    }

    suspend fun saveScore(score: Int) {
        scoreDataStore.edit { preferences ->
            preferences[SCORE_KEY] = score
        }
    }
}


