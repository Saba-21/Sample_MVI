package com.example.saba.sampleMVI.presentation.add.actions

import com.example.saba.sampleMVI.base.structure.actions.ViewStateAction
import com.example.saba.sampleMVI.custom.SHOW_ERROR_STATE
import com.example.saba.sampleMVI.presentation.add.AddingViewState

class ShowErrorAction(private val exception: String): ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = SHOW_ERROR_STATE, exception = exception)

}
