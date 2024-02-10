package com.game.lightsout.presentation.screens.score_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.game.lightsout.util.TURNS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScoreViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _state = MutableStateFlow(ScoreScreenState())
    val state = _state.asStateFlow()

    init {
        savedStateHandle.get<Int>(TURNS)?.let { _state.value = _state.value.copy(turns = it) }
    }

}

