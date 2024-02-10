package com.example.hungrysnake.presentation.screens

import com.example.hungrysnake.presentation.screens.destinations.*
import com.ramcosta.composedestinations.spec.*

/**
 * Class generated if any Composable is annotated with `@Destination`.
 * It aggregates all [TypedDestination]s in their [NavGraph]s.
 */
public object NavGraphs {

    public val root: NavGraph = NavGraph(
        route = "root",
        startRoute = MenuScreenDestination,
        destinations = listOf(
            GameScreenDestination,
			MenuScreenDestination
        )
    )
}