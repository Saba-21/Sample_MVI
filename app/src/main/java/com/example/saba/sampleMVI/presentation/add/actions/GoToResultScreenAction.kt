package com.example.saba.sampleMVI.presentation.add.actions

import com.example.saba.sampleMVI.base.structure.actions.NavigatorAction
import com.example.saba.sampleMVI.presentation.add.AddingNavigator

class GoToResultScreenAction(navigator: AddingNavigator):
        NavigatorAction<AddingNavigator>(navigator){

    override fun commitNavigatorAction() {
        navigator.goToResultScreen()
    }

}