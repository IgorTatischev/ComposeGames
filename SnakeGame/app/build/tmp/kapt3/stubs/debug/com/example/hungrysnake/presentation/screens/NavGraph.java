package com.example.hungrysnake.presentation.screens;

import java.lang.System;

/**
 * Realization of [NavGraphSpec] for the app.
 * It uses [TypedDestination] instead of [DestinationSpec].
 *
 * @see [NavGraphSpec]
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\bj\u0002`\t0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\bj\u0002`\t0\u0007H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u00c6\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\bj\u0002`\t0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\bj\u0002`\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0002\b\u00030\bj\u0002`\t0\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/example/hungrysnake/presentation/screens/NavGraph;", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", "route", "", "startRoute", "Lcom/ramcosta/composedestinations/spec/Route;", "destinations", "", "Lcom/example/hungrysnake/presentation/screens/destinations/TypedDestination;", "Lcom/example/hungrysnake/presentation/screens/destinations/Destination;", "nestedNavGraphs", "(Ljava/lang/String;Lcom/ramcosta/composedestinations/spec/Route;Ljava/util/List;Ljava/util/List;)V", "getDestinations", "()Ljava/util/List;", "destinationsByRoute", "", "getDestinationsByRoute", "()Ljava/util/Map;", "getNestedNavGraphs", "getRoute", "()Ljava/lang/String;", "getStartRoute", "()Lcom/ramcosta/composedestinations/spec/Route;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
public final class NavGraph implements com.ramcosta.composedestinations.spec.NavGraphSpec {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull
    private final com.ramcosta.composedestinations.spec.Route startRoute = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> destinations = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.hungrysnake.presentation.screens.NavGraph> nestedNavGraphs = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> destinationsByRoute = null;
    
    /**
     * Realization of [NavGraphSpec] for the app.
     * It uses [TypedDestination] instead of [DestinationSpec].
     *
     * @see [NavGraphSpec]
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.hungrysnake.presentation.screens.NavGraph copy(@org.jetbrains.annotations.NotNull
    java.lang.String route, @org.jetbrains.annotations.NotNull
    com.ramcosta.composedestinations.spec.Route startRoute, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> destinations, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.hungrysnake.presentation.screens.NavGraph> nestedNavGraphs) {
        return null;
    }
    
    /**
     * Realization of [NavGraphSpec] for the app.
     * It uses [TypedDestination] instead of [DestinationSpec].
     *
     * @see [NavGraphSpec]
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Realization of [NavGraphSpec] for the app.
     * It uses [TypedDestination] instead of [DestinationSpec].
     *
     * @see [NavGraphSpec]
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Realization of [NavGraphSpec] for the app.
     * It uses [TypedDestination] instead of [DestinationSpec].
     *
     * @see [NavGraphSpec]
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public NavGraph(@org.jetbrains.annotations.NotNull
    java.lang.String route, @org.jetbrains.annotations.NotNull
    com.ramcosta.composedestinations.spec.Route startRoute, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> destinations, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.hungrysnake.presentation.screens.NavGraph> nestedNavGraphs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ramcosta.composedestinations.spec.Route component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.ramcosta.composedestinations.spec.Route getStartRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> getDestinations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.hungrysnake.presentation.screens.NavGraph> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.List<com.example.hungrysnake.presentation.screens.NavGraph> getNestedNavGraphs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.Map<java.lang.String, com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> getDestinationsByRoute() {
        return null;
    }
}