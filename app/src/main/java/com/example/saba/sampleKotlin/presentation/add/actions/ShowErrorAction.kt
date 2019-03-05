package com.example.saba.sampleKotlin.presentation.add.actions

import com.example.saba.sampleKotlin.base.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.custom.SHOW_ERROR_STATE
import com.example.saba.sampleKotlin.presentation.add.AddingViewState

class ShowErrorAction(private val exception: String): ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = SHOW_ERROR_STATE, exception = exception)

}
