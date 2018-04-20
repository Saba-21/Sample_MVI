package com.example.saba.sampleKotlin.presentation

import com.example.saba.sampleKotlin.mvi.presenter.BasePresenter
import com.example.saba.sampleKotlin.presentation.mainActions.DrawAddingScreenAction
import com.example.saba.sampleKotlin.presentation.mainActions.DrawResultScreenAction
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
