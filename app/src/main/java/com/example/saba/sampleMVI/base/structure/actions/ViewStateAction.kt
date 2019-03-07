package com.example.saba.sampleMVI.base.structure.actions

abstract class ViewStateAction<ViewState> : Action {
    abstract fun newState(oldState: ViewState): ViewState
}