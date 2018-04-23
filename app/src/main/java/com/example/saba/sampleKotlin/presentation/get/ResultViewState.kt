package com.example.saba.sampleKotlin.presentation.get

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel

const val RESULT_VIEW_INITIAL_STATE = 1
const val RESULT_VIEW_LOADING_STATE = 2
const val RESULT_VIEW_SUCCESS_STATE = 3
const val RESULT_VIEW_ERROR_STATE = 4

data class ResultViewState(val state: Int, val response: List<RepoModel>?, val exception: String?)