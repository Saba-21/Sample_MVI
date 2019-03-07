package com.example.saba.sampleMVI.presentation.get

import com.example.saba.sampleMVI.base.structure.actions.Action
import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.base.structure.presenters.BasePresenter
import com.example.saba.sampleMVI.custom.INITIAL_STATE
import com.example.saba.sampleMVI.domain.useCases.DropLocalReposUseCase
import com.example.saba.sampleMVI.domain.useCases.GetLocalReposUseCase
import com.example.saba.sampleMVI.presentation.get.actions.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResultPresenter(private val resultNavigator: ResultNavigator,
                      private val getLocalReposUseCase: GetLocalReposUseCase,
                      private val dropLocalReposUseCase: DropLocalReposUseCase) :
        BasePresenter<ResultViewState, ResultView>() {

    override fun getInitialViewState():
            ResultViewState = ResultViewState(INITIAL_STATE, null, null)

    override fun onFirstAttach() {
        registerPerPresenterDisposables(
                Observable.fromCallable {
                    dispatchAction(ShowLoaderAction())
                }.flatMap {
                    getLocalRepos()
                }.map {
                    DrawRepoListAction(it) as Action
                }.onErrorReturn {
                    ShowErrorAction(it.toString())
                }.subscribe {
                    dispatchAction(it)
                    dispatchAction(HideLoaderAction())
                }
        )
    }

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(

                getView().onAddingNavigatorClickIntent()
                        .map {
                            GoToAddingScreenAction(resultNavigator)
                        }.subscribe(this::dispatchAction),

                getView().onDropClickIntent()
                        .flatMap {
                            dropLocalRepo(it)
                        }.subscribe({

                        }, {
                            dispatchAction(ShowErrorAction(it.toString()))
                        })
        )
    }

    private fun getLocalRepos():
            Observable<List<RepoModel>> = getLocalReposUseCase
            .createObservable(Unit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun dropLocalRepo(repoModel: RepoModel):
            Observable<RepoModel> = dropLocalReposUseCase
            .createObservable(repoModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}