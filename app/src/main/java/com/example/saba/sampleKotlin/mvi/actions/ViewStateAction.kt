package com.example.saba.sampleKotlin.mvi.actions


abstract class ViewStateAction<ViewState>: Action {

    abstract fun newState(oldState: ViewState): ViewState

    open fun shouldBeSaved(): Boolean = false

}