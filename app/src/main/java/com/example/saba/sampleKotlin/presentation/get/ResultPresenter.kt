package com.example.saba.sampleKotlin.presentation.get

import com.example.saba.sampleKotlin.mvi.presenter.BasePresenter
import com.example.saba.sampleKotlin.domain.useCase.DropLocalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.GetLocalReposUseCase
import com.example.saba.sampleKotlin.presentation.get.actions.GoToAddingScreenAction

class ResultPresenter(private val resultNavigator: ResultNavigator,
                      private val getLocalReposUseCase: GetLocalReposUseCase,
                      private val dropLocalReposUseCase: DropLocalReposUseCase):
        BasePresenter<ResultViewState, ResultView>(){

    override fun getInitialViewState():
            ResultViewState = ResultViewState(RESULT_VIEW_INITIAL_STATE)

    override fun onFirstAttach() {
    }

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(
                getView().onAddingNavigatorClickIntent()
                        .map { GoToAddingScreenAction(resultNavigator) }
                        .subscribe(this::dispatchAction))
    }

}
