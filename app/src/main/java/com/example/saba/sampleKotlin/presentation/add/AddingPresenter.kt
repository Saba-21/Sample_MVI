package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.base.mvi.actions.Action
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.base.mvi.presenters.BasePresenter
import com.example.saba.sampleKotlin.custom.INITIAL_STATE
import com.example.saba.sampleKotlin.domain.useCase.GetGlobalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.SaveLocalRepoUseCase
import com.example.saba.sampleKotlin.presentation.add.actions.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddingPresenter(private val addingNavigator: AddingNavigator,
                      private val getGlobalReposUseCase: GetGlobalReposUseCase,
                      private val saveLocalRepoUseCase: SaveLocalRepoUseCase) :
        BasePresenter<AddingViewState, AddingView>() {

    override fun getInitialViewState():
            AddingViewState = AddingViewState(INITIAL_STATE, null, null)

    override fun onFirstAttach() {}

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(

                getView().onResultNavigatorClickIntent()
                        .map {
                            GoToResultScreenAction(addingNavigator)
                        }.subscribe(this::dispatchAction),

                getView().onSearchClickIntent()
                        .flatMap {
                            dispatchAction(ShowLoaderAction())
                            getGlobalRepos(it)
                        }.map {
                            DrawRepoListAction(it) as Action
                        }.onErrorReturn {
                            ShowErrorAction(it.toString())
                        }.subscribe {
                            dispatchAction(it)
                            dispatchAction(HideLoaderAction())
                        },

                getView().onAddClickIntent()
                        .flatMap {
                            addLocalRepo(it)
                        }.subscribe({

                        }, {
                            dispatchAction(ShowErrorAction(it.toString()))
                        })
        )

    }

    private fun getGlobalRepos(username: String):
            Observable<List<RepoModel>> = getGlobalReposUseCase
            .createObservable(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun addLocalRepo(repoModel: RepoModel):
            Observable<RepoModel> = saveLocalRepoUseCase
            .createObservable(repoModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}