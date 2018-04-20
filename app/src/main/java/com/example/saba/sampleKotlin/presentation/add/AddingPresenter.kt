package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.mvi.presenter.BasePresenter
import com.example.saba.sampleKotlin.domain.useCase.GetGlobalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.SaveLocalRepoUseCase
import com.example.saba.sampleKotlin.presentation.add.actions.GoToResultScreenAction

class AddingPresenter(private val addingNavigator: AddingNavigator,
                      private val getGlobalReposUseCase: GetGlobalReposUseCase,
                      private val saveLocalRepoUseCase: SaveLocalRepoUseCase):
        BasePresenter<AddingViewState, AddingView>(){

    override fun getInitialViewState():
            AddingViewState = AddingViewState(Adding_VIEW_INITIAL_STATE)

    override fun onFirstAttach() {
    }

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(
                getView().onResultScreenNavigatorClickIntent()
                        .map { GoToResultScreenAction(addingNavigator) }
                        .subscribe(this::dispatchAction)
        )
    }

}
