package com.example.saba.sampleKotlin.presentation.add.actions

import com.example.saba.sampleKotlin.base.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.custom.SHOW_LOADER_STATE
import com.example.saba.sampleKotlin.presentation.add.AddingViewState

class ShowLoaderAction: ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = SHOW_LOADER_STATE)

}
