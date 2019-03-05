package com.example.saba.sampleKotlin.presentation.add.actions

import com.example.saba.sampleKotlin.base.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.custom.HIDE_LOADER_STATE
import com.example.saba.sampleKotlin.presentation.add.AddingViewState

class HideLoaderAction : ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = HIDE_LOADER_STATE)

}
