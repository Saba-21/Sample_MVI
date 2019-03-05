package com.example.saba.sampleKotlin.presentation.add.actions

import com.example.saba.sampleKotlin.base.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.presentation.add.DRAW_REPO_LIST_STATE
import com.example.saba.sampleKotlin.presentation.add.AddingViewState

class DrawRepoListAction(private val response: List<RepoModel>):
        ViewStateAction<AddingViewState>() {

    override fun newState(oldState: AddingViewState):
            AddingViewState = oldState.copy(state = DRAW_REPO_LIST_STATE, response = response)

}
