package com.example.saba.sampleKotlin.presentation.get.actions

import com.example.saba.sampleKotlin.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.presentation.get.RESULT_VIEW_ERROR_STATE
import com.example.saba.sampleKotlin.presentation.get.ResultViewState

class ErrorStateAction(private val exception: String): ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = RESULT_VIEW_ERROR_STATE, exception = exception)
}
