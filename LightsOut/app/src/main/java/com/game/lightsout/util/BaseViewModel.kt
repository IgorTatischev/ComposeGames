package com.game.lightsout.util

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel<Intent : UiIntent, State : Any, Effect : UiEffect>(initialState: State) :
    ContainerHost<State, Effect>, IntentHandler<Intent>, ViewModel() {

    override val container =
        container<State, Effect>(initialState)

    fun post(sideEffect: Effect) = intent { postSideEffect(sideEffect) }

}