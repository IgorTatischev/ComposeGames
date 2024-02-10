package com.doodler.jumper.game.screens.menu_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doodler.jumper.game.datastore.ScoreDataStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MenuViewModel(scoreDataStore: ScoreDataStore) : ViewModel() {

    val readScore: StateFlow<Long> = scoreDataStore.getScore.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )

}