package com.example.saba.sampleKotlin.presentation.get

import com.example.saba.sampleKotlin.base.BasePresenter

class ResultPresenter(private val resultNavigator: ResultNavigator) : BasePresenter<ResultView>(){

    fun goToAddingScreen(){ resultNavigator.goToAddingScreen() }
}
