package com.example.hungrysnake.presentation.screens.menu;

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
public final class MenuViewModel_Factory implements Factory<MenuViewModel> {
  private final Provider<ScoreDataStore> scoreDataStoreProvider;

  public MenuViewModel_Factory(Provider<ScoreDataStore> scoreDataStoreProvider) {
    this.scoreDataStoreProvider = scoreDataStoreProvider;
  }

  @Override
  public MenuViewModel get() {
    return newInstance(scoreDataStoreProvider.get());
  }

  public static MenuViewModel_Factory create(Provider<ScoreDataStore> scoreDataStoreProvider) {
    return new MenuViewModel_Factory(scoreDataStoreProvider);
  }

  public static MenuViewModel newInstance(ScoreDataStore scoreDataStore) {
    return new MenuViewModel(scoreDataStore);
  }
}
