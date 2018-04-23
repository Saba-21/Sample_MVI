package com.example.saba.sampleKotlin.presentation.add.actions

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.presentation.add.ADDING_VIEW_SUCCESS_STATE
import com.example.saba.sampleKotlin.presentation.add.AddingViewState

class ResponseSuccessStateAction(private val response: List<RepoModel>): ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = ADDING_VIEW_SUCCESS_STATE, response = response)

}
