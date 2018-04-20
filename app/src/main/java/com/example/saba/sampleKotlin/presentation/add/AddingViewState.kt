package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel

const val ADDING_VIEW_INITIAL_STATE = 1
const val ADDING_VIEW_ERROR_STATE = 2
const val ADDING_VIEW_SUCCESS_STATE = 3
const val ADDING_VIEW_LOADING_STATE = 4

data class AddingViewState(val state: Int, val result: List<RepoModel>?, val exception: String?)