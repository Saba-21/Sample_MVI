package com.example.saba.sampleMVI.presentation.get.actions

import com.example.saba.sampleMVI.base.structure.actions.NavigatorAction
import com.example.saba.sampleMVI.presentation.get.ResultNavigator

class GoToAddingScreenAction(navigator: ResultNavigator):
        NavigatorAction<ResultNavigator>(navigator){

    override fun commitNavigatorAction() {
        navigator.goToAddingScreen()
    }

}