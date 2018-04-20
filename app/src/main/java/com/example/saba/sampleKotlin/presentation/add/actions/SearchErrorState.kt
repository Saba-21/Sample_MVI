package com.example.saba.sampleKotlin.presentation.add.actions

import com.example.saba.sampleKotlin.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.presentation.add.ADDING_VIEW_ERROR_STATE
import com.example.saba.sampleKotlin.presentation.add.AddingViewState


class SearchErrorState(private val exception: String): ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = ADDING_VIEW_ERROR_STATE, exception = exception)

}
