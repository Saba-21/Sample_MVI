package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.mvi.presenter.BasePresenter
import com.example.saba.sampleKotlin.domain.useCase.GetGlobalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.SaveLocalRepoUseCase
import com.example.saba.sampleKotlin.presentation.add.actions.GoToResultScreenAction
import com.example.saba.sampleKotlin.presentation.add.actions.SearchErrorState
import com.example.saba.sampleKotlin.presentation.add.actions.SearchLoadingAction
import com.example.saba.sampleKotlin.presentation.add.actions.SearchSuccessAction
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddingPresenter(private val addingNavigator: AddingNavigator,
                      private val getGlobalReposUseCase: GetGlobalReposUseCase,
                      private val saveLocalRepoUseCase: SaveLocalRepoUseCase):
        BasePresenter<AddingViewState, AddingView>(){

    override fun getInitialViewState():
            AddingViewState = AddingViewState(ADDING_VIEW_INITIAL_STATE,null, null)

    override fun onFirstAttach() {
    }

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(
                getView().onResultNavigatorClickIntent().map { GoToResultScreenAction(addingNavigator) }.subscribe(this::dispatchAction),

                getView().onSearchClickIntent()
                        .flatMap{ getGlobalRepos(it)}
                        .subscribe(
                                { dispatchAction(SearchSuccessAction(it)) },
                                { dispatchAction(SearchErrorState(it.toString())) }
                        )
                )
    }

    private fun getGlobalRepos(username: String): Observable<List<RepoModel>> {
        dispatchAction(SearchLoadingAction())
        return getGlobalReposUseCase
                    .createObservable(username)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
    }
}
