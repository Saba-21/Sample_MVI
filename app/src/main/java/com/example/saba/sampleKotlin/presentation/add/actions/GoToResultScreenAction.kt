package com.example.saba.sampleKotlin.presentation.add.actions

import com.example.saba.sampleKotlin.base.mvi.actions.NavigatorAction
import com.example.saba.sampleKotlin.presentation.add.AddingNavigator

class GoToResultScreenAction(navigator: AddingNavigator):
        NavigatorAction<AddingNavigator>(navigator){

    override fun commitNavigatorAction() {
        navigator.goToResultScreen()
    }

}