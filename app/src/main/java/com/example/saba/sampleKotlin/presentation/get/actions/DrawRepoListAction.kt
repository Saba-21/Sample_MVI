package com.example.saba.sampleKotlin.presentation.get.actions

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.base.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.presentation.get.DRAW_REPO_LIST_STATE
import com.example.saba.sampleKotlin.presentation.get.ResultViewState

class DrawRepoListAction(private val response: List<RepoModel>): ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = DRAW_REPO_LIST_STATE, response = response)

}
