package com.example.hungrysnake.presentation.screens.game;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/hungrysnake/presentation/screens/game/GameState;", "", "()V", "Running", "Score", "Lcom/example/hungrysnake/presentation/screens/game/GameState$Running;", "Lcom/example/hungrysnake/presentation/screens/game/GameState$Score;", "app_debug"})
public abstract class GameState {
    
    private GameState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u00a2\u0006\u0002\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/hungrysnake/presentation/screens/game/GameState$Running;", "Lcom/example/hungrysnake/presentation/screens/game/GameState;", "food", "Lkotlin/Pair;", "", "snake", "", "(Lkotlin/Pair;Ljava/util/List;)V", "getFood", "()Lkotlin/Pair;", "getSnake", "()Ljava/util/List;", "app_debug"})
    public static final class Running extends com.example.hungrysnake.presentation.screens.game.GameState {
        @org.jetbrains.annotations.NotNull
        private final kotlin.Pair<java.lang.Integer, java.lang.Integer> food = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<kotlin.Pair<java.lang.Integer, java.lang.Integer>> snake = null;
        
        public Running() {
            super();
        }
        
        public Running(@org.jetbrains.annotations.NotNull
        kotlin.Pair<java.lang.Integer, java.lang.Integer> food, @org.jetbrains.annotations.NotNull
        java.util.List<kotlin.Pair<java.lang.Integer, java.lang.Integer>> snake) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.Pair<java.lang.Integer, java.lang.Integer> getFood() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<kotlin.Pair<java.lang.Integer, java.lang.Integer>> getSnake() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/hungrysnake/presentation/screens/game/GameState$Score;", "Lcom/example/hungrysnake/presentation/screens/game/GameState;", "score", "", "(J)V", "getScore", "()J", "app_debug"})
    public static final class Score extends com.example.hungrysnake.presentation.screens.game.GameState {
        private final long score = 0L;
        
        public Score() {
            super();
        }
        
        public Score(long score) {
            super();
        }
        
        public final long getScore() {
            return 0L;
        }
    }
}