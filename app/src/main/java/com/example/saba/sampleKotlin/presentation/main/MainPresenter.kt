package com.example.saba.sampleKotlin.presentation.main

import com.example.saba.sampleKotlin.base.mvi.presenters.BasePresenter
import com.example.saba.sampleKotlin.presentation.main.actions.DrawAddingScreenAction
import com.example.saba.sampleKotlin.presentation.main.actions.DrawResultScreenAction
import com.example.saba.sampleKotlin.presentation.add.AddingNavigator
import com.example.saba.sampleKotlin.presentation.get.ResultNavigator

class MainPresenter: BasePresenter<MainViewState, MainView>(),
        AddingNavigator, ResultNavigator {

    override fun getInitialViewState():
            MainViewState = MainViewState(MAIN_VIEW_DRAW_ADDING_SCREEN_STATE)

    override fun onFirstAttach() {
    }

    override fun onAttach(isFirstAttach: Boolean) {
    }

    override fun goToResultScreen() {
        dispatchAction(DrawResultScreenAction())
    }

    override fun goToAddingScreen() {
        dispatchAction(DrawAddingScreenAction())
    }

}
