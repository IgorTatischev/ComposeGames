package com.cardgame.memorycard.game.screens.game_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardgame.memorycard.game.util.CardModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private var planes: MutableList<CardModel> = mutableListOf()

    private val _state = mutableStateOf(GameScreenState())
    val state: State<GameScreenState> = _state

    init {
        loadCards()
    }

    fun loadCards() {
        planes = mutableListOf(
            CardModel(char = "\uD83D\uDEEC"),
            CardModel(char = "\uD83D\uDEEC"),
            CardModel(char = "\uD83D\uDE81"),
            CardModel(char = "\uD83D\uDE81"),
            CardModel(char = "\uD83D\uDEE9"),
            CardModel(char = "\uD83D\uDEE9"),
            CardModel(char = "\uD83D\uDEEB"),
            CardModel(char = "\uD83D\uDEEB"),
            CardModel(char = "\uD83C\uDF0F"),
            CardModel(char = "\uD83C\uDF0F"),
            CardModel(char = "✈️"),
            CardModel(char = "✈️"),
        ).apply { shuffle() }
        _state.value = _state.value.copy(running = GameState.Game, list = planes, turns = 0)
    }

    fun updateShowVisibleCard(id: String) {

        var turns = _state.value.turns
        turns += 1

        val selects: List<CardModel> = planes.filter { it.isSelect }
        var charFind = ""

        if (selects.size >= 2) {
            val isSameChar: Boolean = selects[0].char == selects[1].char
            if (isSameChar) {
                charFind = selects[0].char
            }
        }

        planes = planes.map {
            if (selects.size >= 2) {
                it.isSelect = false
            }

            if (it.char == charFind) {
                it.isVisible = false
            }

            if (it.id == id) {
                it.isSelect = true
            }

            it
        }.toMutableList()

        val visibleCount: Int = planes.filter { it.isVisible }.size
        val selectedCount: Int = planes.filter { it.isSelect }.size
        if (visibleCount <= 2) {
            if (selectedCount == 2) {
                _state.value = _state.value.copy(running = GameState.Score)
                return
            }
        }

        _state.value = _state.value.copy(list = planes, turns = turns)
    }
}
