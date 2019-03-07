package com.example.saba.sampleMVI.presentation.add.actions

import com.example.saba.sampleMVI.base.structure.actions.ViewStateAction
import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.presentation.add.DRAW_REPO_LIST_STATE
import com.example.saba.sampleMVI.presentation.add.AddingViewState

class DrawRepoListAction(private val response: List<RepoModel>):
        ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = DRAW_REPO_LIST_STATE, response = response)

}
