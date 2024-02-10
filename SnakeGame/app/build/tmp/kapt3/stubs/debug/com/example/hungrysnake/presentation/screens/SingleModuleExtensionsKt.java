package com.example.hungrysnake.presentation.screens;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0016*\u00020\u0004H\u0007\u001a\u0012\u0010\u0017\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u00020\b\u001a\"\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\"\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u00030\u0001*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"*\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00020\b8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u001d\u0010\r\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"&\u0010\u0011\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u00020\u000e8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"appCurrentDestinationFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/hungrysnake/presentation/screens/destinations/TypedDestination;", "Lcom/example/hungrysnake/presentation/screens/destinations/Destination;", "Landroidx/navigation/NavController;", "getAppCurrentDestinationFlow", "(Landroidx/navigation/NavController;)Lkotlinx/coroutines/flow/Flow;", "navDestination", "Landroidx/navigation/NavBackStackEntry;", "getNavDestination$annotations", "(Landroidx/navigation/NavBackStackEntry;)V", "getNavDestination", "(Landroidx/navigation/NavBackStackEntry;)Lcom/example/hungrysnake/presentation/screens/destinations/TypedDestination;", "startAppDestination", "Lcom/ramcosta/composedestinations/spec/Route;", "getStartAppDestination", "(Lcom/ramcosta/composedestinations/spec/Route;)Lcom/example/hungrysnake/presentation/screens/destinations/TypedDestination;", "startDestination", "getStartDestination$annotations", "(Lcom/ramcosta/composedestinations/spec/Route;)V", "getStartDestination", "appCurrentDestinationAsState", "Landroidx/compose/runtime/State;", "appDestination", "navGraph", "Lcom/example/hungrysnake/presentation/screens/NavGraph;", "app_debug"})
public final class SingleModuleExtensionsKt {
    
    @org.jetbrains.annotations.NotNull
    public static final com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?> getStartAppDestination(@org.jetbrains.annotations.NotNull
    com.ramcosta.composedestinations.spec.Route $this$startAppDestination) {
        return null;
    }
    
    /**
     * Finds the [Destination] correspondent to this [NavBackStackEntry].
     * Some [NavBackStackEntry] are not [Destination], but are [NavGraph] instead.
     * If you want a method that works for both, use [route] extension function instead.
     *
     * Use this ONLY if you're sure your [NavBackStackEntry] corresponds to a [Destination],
     * for example when converting from "current NavBackStackEntry", since a [NavGraph] is never
     * the "current destination" shown on screen.
     */
    @org.jetbrains.annotations.NotNull
    public static final com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?> appDestination(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavBackStackEntry $this$appDestination) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.flow.Flow<com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> getAppCurrentDestinationFlow(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController $this$appCurrentDestinationFlow) {
        return null;
    }
    
    /**
     * Gets the current [Destination] as a [State].
     */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    public static final androidx.compose.runtime.State<com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?>> appCurrentDestinationAsState(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController $this$appCurrentDestinationAsState) {
        return null;
    }
    
    /**
     * If this [Route] is a [Destination], returns it
     *
     * If this [Route] is a [NavGraph], returns its
     * start [Destination].
     */
    @java.lang.Deprecated
    public static void getStartDestination$annotations(com.ramcosta.composedestinations.spec.Route p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Deprecated
    public static final com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?> getStartDestination(@org.jetbrains.annotations.NotNull
    com.ramcosta.composedestinations.spec.Route $this$startDestination) {
        return null;
    }
    
    /**
     * Finds the destination correspondent to this [NavBackStackEntry] in the root NavGraph, null if none is found
     * or if no route is set in this back stack entry's destination.
     */
    @java.lang.Deprecated
    public static void getNavDestination$annotations(androidx.navigation.NavBackStackEntry p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Deprecated
    public static final com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?> getNavDestination(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavBackStackEntry $this$navDestination) {
        return null;
    }
    
    /**
     * Finds the destination correspondent to this [NavBackStackEntry] in [navGraph], null if none is found
     * or if no route is set in this back stack entry's destination.
     */
    @org.jetbrains.annotations.Nullable
    @java.lang.Deprecated
    public static final com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?> navDestination(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavBackStackEntry $this$navDestination, @org.jetbrains.annotations.NotNull
    com.example.hungrysnake.presentation.screens.NavGraph navGraph) {
        return null;
    }
    
    /**
     * Finds the destination correspondent to this [NavBackStackEntry] in [navGraph], null if none is found
     * or if no route is set in this back stack entry's destination.
     */
    @org.jetbrains.annotations.Nullable
    @java.lang.Deprecated
    public static final com.example.hungrysnake.presentation.screens.destinations.TypedDestination<?> appDestination(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavBackStackEntry $this$appDestination, @org.jetbrains.annotations.NotNull
    com.example.hungrysnake.presentation.screens.NavGraph navGraph) {
        return null;
    }
}