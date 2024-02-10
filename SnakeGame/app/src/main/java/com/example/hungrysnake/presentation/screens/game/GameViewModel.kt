package com.example.hungrysnake.presentation.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hungrysnake.datastore.ScoreDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Random
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(private val scoreDataStore: ScoreDataStore) : ViewModel() {

    private var job: Job? = null

    private val _state = MutableStateFlow<GameState>(GameState.Running())
    val state = _state.asStateFlow()
    private var running: Boolean = true

    private var snakeLength = 0

    var direction = Pair(1, 0)
        set(value) {
            viewModelScope.launch {
                if (!(field.first != value.first && field.second == value.second) &&
                    !(field.second != value.second && field.first == value.first)
                ) {
                    field = value
                }
            }
        }

    fun play() {
        if (job?.isActive != true) {
            job = viewModelScope.launch {

                snakeLength = 2

                while (running) with(_state.value as GameState.Running) {
                    delay(150)
                    _state.update {

                        val newPosition = snake.first().let { poz ->
                            Pair(
                                (poz.first + direction.first + BOARD_SIZE) % BOARD_SIZE,
                                (poz.second + direction.second + BOARD_SIZE) % BOARD_SIZE
                            )
                        }

                        if (newPosition == food) {
                            snakeLength++
                        }

                        if (snake.contains(newPosition)) {
                            running = false
                            scoreDataStore.saveScore(snakeLength)
                            job?.cancel()
                        }

                        GameState.Running(
                            food = if (newPosition == food) Pair(
                                Random().nextInt(BOARD_SIZE),
                                Random().nextInt(BOARD_SIZE)
                            ) else food,
                            snake = listOf(newPosition) + snake.take(snakeLength - 1),
                        )
                    }
                }
                _state.value = GameState.Score(snakeLength.toLong())
            }
        }
    }

    companion object {
        const val BOARD_SIZE = 16
    }
}