package com.example.hungrysnake.presentation.screens.menu;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/hungrysnake/presentation/screens/menu/MenuViewModel;", "Landroidx/lifecycle/ViewModel;", "scoreDataStore", "Lcom/example/hungrysnake/datastore/ScoreDataStore;", "(Lcom/example/hungrysnake/datastore/ScoreDataStore;)V", "readScore", "Lkotlinx/coroutines/flow/StateFlow;", "", "getReadScore", "()Lkotlinx/coroutines/flow/StateFlow;", "app_debug"})
public final class MenuViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.hungrysnake.datastore.ScoreDataStore scoreDataStore = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> readScore = null;
    
    @javax.inject.Inject
    public MenuViewModel(@org.jetbrains.annotations.NotNull
    com.example.hungrysnake.datastore.ScoreDataStore scoreDataStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getReadScore() {
        return null;
    }
}