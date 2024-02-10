package com.doodler.jumper.game.screens.game_screen

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doodler.jumper.game.datastore.ScoreDataStore
import com.doodler.jumper.game.entities.Platform
import com.doodler.jumper.game.entities.Pot
import com.doodler.jumper.game.util.Bitmaps
import com.doodler.jumper.game.util.Bitmaps.screenHeight
import com.doodler.jumper.game.util.Bitmaps.screenWidth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GameViewModel(private val scoreDataStore: ScoreDataStore) : ViewModel() {

    private var resources: Resources? = null

    private var job: Job? = null

    private var startTime: Long = 0
    private var frameTime: Long = 0
    private val neededFrameTime: Int = (1000.0 / 60.0).toInt()

    private val _state = MutableStateFlow(GameScreenState())
    val state = _state.asStateFlow()

    private var currentScore: Long = 0
    private val gap = screenHeight / 5

    fun setRes(res: Resources) {
        resources = res
    }

    fun play() {

        currentScore = 0
        _state.value = GameScreenState()

        if (job?.isActive != true) {
            job = viewModelScope.launch(Dispatchers.Default + SupervisorJob()) {

                initialize()

                while (_state.value.running is GameState.Game) {

                    startTime = System.currentTimeMillis()
                    spawn()
                    jump()
                    movePotDown()

                    _state.value = _state.value.copy(
                        score = currentScore,
                        time = System.currentTimeMillis()
                    )

                    frameTime = System.currentTimeMillis() - startTime
                    if (frameTime < neededFrameTime) {
                        delay(neededFrameTime - frameTime)
                    }
                }
            }
        }
    }

    private fun initialize() = with(_state.value) {
        resources?.let { Bitmaps.initialize(resources = it) }
        val platforms = mutableListOf<Platform>()

        for (i in 1..5) {
            val platform = Platform().also { it.init((screenHeight - i * gap).toFloat()) }
            platforms += platform
        }

        _state.value = copy(
            platforms = platforms.toList(),
            player = player.also { it.init() },
            pot = pot.also { it.init() }
        )
    }

    private fun spawn() = with(_state.value) {
        val platforms = platforms.toMutableList()

        if (player.y < platforms[platforms.size - 1].y + 200) {
            val platform = Platform().also { it.init((platforms[platforms.size - 1].y - gap)) }
            platforms.add(platform)
        } else if (platforms[0].y > player.y + screenHeight) {
            platforms.removeAt(0)
            currentScore++
        }
        _state.value = copy(platforms = platforms.toList())
    }

    private fun movePotDown() = with(_state.value) {
        var newPot = pot
        newPot.y += 10f
        newPot.setRect()

        if (pot.y > player.y + screenHeight) {
            newPot = Pot().also { it.init() }
        }

        if (pot.hasCollision(player)) {
            saveRecord()
            _state.value = _state.value.copy(running = GameState.Score)
            job?.cancel()
        }
        _state.value = _state.value.copy(pot = newPot)
    }

    private fun movePlayer() = with(_state.value) {
        _state.value = _state.value.copy(
            player = player.also { player ->
                if ((player.x > 0 || player.playerDirection == 1) &&
                    (player.x < screenWidth - player.width || player.playerDirection == -1)
                ) {
                    player.x += player.speed * player.playerDirection
                }
            }
        )
    }

    fun changeDirection(x: Float) = with(_state.value) {
        _state.value = _state.value.copy(
            player = player.also { player ->
                player.playerDirection = if (x > screenWidth / 2) 1 else -1
            }
        )
    }

    fun stopMovingPlayer() = with(_state.value) {
        _state.value = _state.value.copy(
            player = player.also { plane ->
                plane.playerDirection = 0
            }
        )
    }

    private fun jump() = with(_state.value) {

        if (player.velocity < -player.jumpForce) player.velocity = -player.jumpForce
        player.velocity += player.gravity
        player.y += player.velocity
        player.setRect()

        platforms.forEach { platform ->
            if (player.y + player.height >= platform.y && player.y + player.height <= platform.y + platform.height) {
                val minX = platform.x - player.width
                val maxX = platform.x + platform.width
                if (player.x in minX..maxX) {
                    player.velocity -= player.jumpForce
                }
            }
        }

        movePlayer()

        if (player.velocity > 30) {
            saveRecord()
            _state.value = _state.value.copy(running = GameState.Score)
            job?.cancel()
        }
    }

    private fun saveRecord() {
        viewModelScope.launch(Dispatchers.IO) {
            scoreDataStore.getScore.collectLatest { record ->
                if (currentScore > record) {
                    scoreDataStore.saveScore(currentScore)
                }
            }
        }
    }
}