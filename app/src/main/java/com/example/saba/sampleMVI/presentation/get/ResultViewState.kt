package com.example.saba.sampleMVI.presentation.get

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel

const val DRAW_REPO_LIST_STATE = 3

data class ResultViewState(val state: Int, val response: List<RepoModel>?, val exception: String?)