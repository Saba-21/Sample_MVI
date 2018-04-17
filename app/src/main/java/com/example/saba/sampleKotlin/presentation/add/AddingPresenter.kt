package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.base.BasePresenter

class AddingPresenter(private val addingNavigator: AddingNavigator) : BasePresenter<AddingView>(){

    fun goToResultsScreen(){addingNavigator.goToResultsScreen()}
}
