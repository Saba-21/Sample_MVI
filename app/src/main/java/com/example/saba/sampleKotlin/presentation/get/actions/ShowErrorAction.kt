package com.example.saba.sampleKotlin.presentation.get.actions

import com.example.saba.sampleKotlin.base.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.custom.SHOW_ERROR_STATE
import com.example.saba.sampleKotlin.presentation.get.ResultViewState

class ShowErrorAction(private val exception: String): ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = SHOW_ERROR_STATE, exception = exception)
}
