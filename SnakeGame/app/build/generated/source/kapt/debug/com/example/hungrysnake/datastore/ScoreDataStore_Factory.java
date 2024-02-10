package com.example.hungrysnake.datastore;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ScoreDataStore_Factory implements Factory<ScoreDataStore> {
  private final Provider<Context> contextProvider;

  public ScoreDataStore_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ScoreDataStore get() {
    return newInstance(contextProvider.get());
  }

  public static ScoreDataStore_Factory create(Provider<Context> contextProvider) {
    return new ScoreDataStore_Factory(contextProvider);
  }

  public static ScoreDataStore newInstance(Context context) {
    return new ScoreDataStore(context);
  }
}
