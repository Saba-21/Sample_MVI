package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel

const val DRAW_REPO_LIST_STATE = 3

data class AddingViewState(val state: Int, val response: List<RepoModel>?, val exception: String?)