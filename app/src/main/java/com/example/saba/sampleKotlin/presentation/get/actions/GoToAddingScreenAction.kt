package com.example.saba.sampleKotlin.presentation.get.actions

import com.example.saba.sampleKotlin.mvi.actions.NavigatorAction
import com.example.saba.sampleKotlin.presentation.get.ResultNavigator

class GoToAddingScreenAction(navigator: ResultNavigator):
        NavigatorAction<ResultNavigator>(navigator){

    override fun commitNavigatorAction() {
        navigator.goToAddingScreen()
    }

}