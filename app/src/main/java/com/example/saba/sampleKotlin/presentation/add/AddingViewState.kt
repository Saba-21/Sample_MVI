package com.example.saba.sampleKotlin.presentation.add

const val Adding_VIEW_INITIAL_STATE = 1
const val Adding_VIEW_ERROR_STATE = 2
const val Adding_VIEW_LOADING_STATE = 3

data class AddingViewState(val state: Int)