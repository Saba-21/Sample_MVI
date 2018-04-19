package com.example.saba.sampleKotlin.presentation

import com.example.saba.sampleKotlin.base.BasePresenter
import com.example.saba.sampleKotlin.presentation.add.AddingNavigator
import com.example.saba.sampleKotlin.presentation.get.ResultNavigator

class MainPresenter: BasePresenter<MainView>(), AddingNavigator, ResultNavigator {

    override fun goToAddingScreen(){mView?.drawAddingFragment()}

    override fun goToResultScreen(){mView?.drawResultFragment()}

}
