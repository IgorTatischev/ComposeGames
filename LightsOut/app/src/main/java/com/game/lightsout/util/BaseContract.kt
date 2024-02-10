package com.game.lightsout.util

interface UiIntent

interface UiEffect

interface IntentHandler<Intent : UiIntent> {
    fun dispatch(intent: Intent)
}