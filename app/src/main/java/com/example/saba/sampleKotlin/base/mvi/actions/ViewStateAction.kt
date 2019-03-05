package com.example.saba.sampleKotlin.base.mvi.actions

abstract class ViewStateAction<ViewState> : Action {
    abstract fun newState(oldState: ViewState): ViewState
}