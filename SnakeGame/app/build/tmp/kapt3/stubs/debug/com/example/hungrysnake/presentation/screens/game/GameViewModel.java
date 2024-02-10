package com.example.hungrysnake.presentation.screens.game;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R<\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/example/hungrysnake/presentation/screens/game/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "scoreDataStore", "Lcom/example/hungrysnake/datastore/ScoreDataStore;", "(Lcom/example/hungrysnake/datastore/ScoreDataStore;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/hungrysnake/presentation/screens/game/GameState;", "value", "Lkotlin/Pair;", "", "direction", "getDirection", "()Lkotlin/Pair;", "setDirection", "(Lkotlin/Pair;)V", "job", "Lkotlinx/coroutines/Job;", "running", "", "snakeLength", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "play", "", "Companion", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.hungrysnake.datastore.ScoreDataStore scoreDataStore = null;
    private kotlinx.coroutines.Job job;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.hungrysnake.presentation.screens.game.GameState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.hungrysnake.presentation.screens.game.GameState> state = null;
    private boolean running = true;
    private int snakeLength = 0;
    @org.jetbrains.annotations.NotNull
    private kotlin.Pair<java.lang.Integer, java.lang.Integer> direction;
    @org.jetbrains.annotations.NotNull
    public static final com.example.hungrysnake.presentation.screens.game.GameViewModel.Companion Companion = null;
    public static final int BOARD_SIZE = 16;
    
    @javax.inject.Inject
    public GameViewModel(@org.jetbrains.annotations.NotNull
    com.example.hungrysnake.datastore.ScoreDataStore scoreDataStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.hungrysnake.presentation.screens.game.GameState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> getDirection() {
        return null;
    }
    
    public final void setDirection(@org.jetbrains.annotations.NotNull
    kotlin.Pair<java.lang.Integer, java.lang.Integer> value) {
    }
    
    public final void play() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/hungrysnake/presentation/screens/game/GameViewModel$Companion;", "", "()V", "BOARD_SIZE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}