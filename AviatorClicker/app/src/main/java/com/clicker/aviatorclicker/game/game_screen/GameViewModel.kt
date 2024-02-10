package com.clicker.aviatorclicker.game.game_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clicker.aviatorclicker.game.data.model.Bonus
import com.clicker.aviatorclicker.game.data.model.BonusItems
import com.clicker.aviatorclicker.game.data.model.Item
import com.clicker.aviatorclicker.game.data.repository.Repository
import com.clicker.aviatorclicker.game.datastore.ScoreDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GameViewModel(
    private val store: ScoreDataStore,
    private val repository: Repository,
) : ViewModel() {

    private var job: Job? = null
    private var startTime: Long = 0
    private var frameTime: Long = 0
    private val neededFrameTime: Int = (10000).toInt()

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    private var currentScore: Long = 0

    init {
        viewModelScope.launch(Dispatchers.IO) {
            store.getScore.collectLatest {
                currentScore = it
                _state.value = _state.value.copy(score = currentScore)
            }
        }

        viewModelScope.launch {
            repository.getBonuses().collect { items ->
                val bonuses = items.map { item ->
                    val bonusItem = BonusItems.valueOf(item.name)
                    Bonus(bonusItem, item.count)
                }.toMutableList()

                _state.value = _state.value.copy(
                    score = currentScore,
                    bonuses = bonuses
                )
            }
        }
    }

    fun play() {
        if (job?.isActive != true) {
            job = viewModelScope.launch(Dispatchers.Default) {

                while (true) {

                    startTime = System.currentTimeMillis()
                    _state.value.bonuses.forEach {
                        currentScore += (it.count * it.bonusItem.ratio).toInt()
                        store.saveScore(currentScore)
                    }
                    _state.value = _state.value.copy(
                        score = currentScore,
                    )

                    frameTime = System.currentTimeMillis() - startTime
                    if (frameTime < neededFrameTime) {
                        delay(neededFrameTime - frameTime)
                    }
                }
            }
        }
    }

    fun addScore() {
        currentScore++
        _state.value = _state.value.copy(
            score = currentScore,
        )
        viewModelScope.launch(Dispatchers.IO) {
            store.saveScore(currentScore)
        }
    }

    fun buyBonus(bonusItems: BonusItems, price: Long) {
        if (currentScore - price >= 0) {
            currentScore -= price
            viewModelScope.launch(Dispatchers.IO) {
                val item = repository.getBonus(bonusItems.name)
                var count = item?.count ?: 0
                count++
                repository.insertBonus(
                    item = Item(
                        name = bonusItems.name,
                        count = count
                    )
                )
                store.saveScore(currentScore)
            }
            _state.value = _state.value.copy(score = currentScore)
        }
    }
}



