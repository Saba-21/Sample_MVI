package com.example.saba.sampleKotlin.presentation.get.actions

import com.example.saba.sampleKotlin.base.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.custom.HIDE_LOADER_STATE
import com.example.saba.sampleKotlin.presentation.get.ResultViewState

class HideLoaderAction: ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = HIDE_LOADER_STATE)

}
