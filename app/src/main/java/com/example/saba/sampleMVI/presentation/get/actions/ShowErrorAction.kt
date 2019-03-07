package com.example.saba.sampleMVI.presentation.get.actions

import com.example.saba.sampleMVI.base.structure.actions.ViewStateAction
import com.example.saba.sampleMVI.custom.SHOW_ERROR_STATE
import com.example.saba.sampleMVI.presentation.get.ResultViewState

class ShowErrorAction(private val exception: String): ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = SHOW_ERROR_STATE, exception = exception)
}
