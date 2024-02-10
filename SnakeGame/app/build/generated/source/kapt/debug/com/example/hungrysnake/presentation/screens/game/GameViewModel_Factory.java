package com.example.hungrysnake.presentation.screens.game;

import com.example.hungrysnake.datastore.ScoreDataStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GameViewModel_Factory implements Factory<GameViewModel> {
  private final Provider<ScoreDataStore> scoreDataStoreProvider;

  public GameViewModel_Factory(Provider<ScoreDataStore> scoreDataStoreProvider) {
    this.scoreDataStoreProvider = scoreDataStoreProvider;
  }

  @Override
  public GameViewModel get() {
    return newInstance(scoreDataStoreProvider.get());
  }

  public static GameViewModel_Factory create(Provider<ScoreDataStore> scoreDataStoreProvider) {
    return new GameViewModel_Factory(scoreDataStoreProvider);
  }

  public static GameViewModel newInstance(ScoreDataStore scoreDataStore) {
    return new GameViewModel(scoreDataStore);
  }
}
