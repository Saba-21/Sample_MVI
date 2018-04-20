package com.example.saba.sampleKotlin.presentation.get

const val Result_VIEW_INITIAL_STATE = 1
const val Result_VIEW_ERROR_STATE = 2
const val Result_VIEW_LOADING_STATE = 3

data class ResultViewState(val state: Int)