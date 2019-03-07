package com.example.saba.sampleMVI.presentation.get.actions

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.base.structure.actions.ViewStateAction
import com.example.saba.sampleMVI.presentation.get.DRAW_REPO_LIST_STATE
import com.example.saba.sampleMVI.presentation.get.ResultViewState

class DrawRepoListAction(private val response: List<RepoModel>): ViewStateAction<ResultViewState>() {

    override fun newState(oldState: ResultViewState):
            ResultViewState = oldState.copy(state = DRAW_REPO_LIST_STATE, response = response)

}
