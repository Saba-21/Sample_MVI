package com.example.saba.sampleKotlin.presentation.get.actions

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.presentation.get.RESULT_VIEW_SUCCESS_STATE
import com.example.saba.sampleKotlin.presentation.get.ResultViewState

class ResponseSuccessStateAction(private val response: List<RepoModel>): ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = RESULT_VIEW_SUCCESS_STATE, response = response)

}
