package com.example.saba.sampleKotlin.presentation.get

import android.util.Log
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.mvi.presenter.BasePresenter
import com.example.saba.sampleKotlin.domain.useCase.DropLocalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.GetLocalReposUseCase
import com.example.saba.sampleKotlin.presentation.get.actions.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResultPresenter(private val resultNavigator: ResultNavigator,
                      private val getLocalReposUseCase: GetLocalReposUseCase,
                      private val dropLocalReposUseCase: DropLocalReposUseCase):
        BasePresenter<ResultViewState, ResultView>(){

    override fun getInitialViewState():
            ResultViewState = ResultViewState(RESULT_VIEW_INITIAL_STATE,null, null)

    override fun onFirstAttach() { }

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(
                getView().onAddingNavigatorClickIntent()
                        .map { GoToAddingScreenAction(resultNavigator) }
                        .subscribe(this::dispatchAction)
                )

        registerPerPresenterDisposables(
                getView().onInitialIntent()
                        .flatMap { getLocalRepos() }
                        .subscribe(
                                {dispatchAction(ResponseSuccessStateAction(it))},
                                {dispatchAction(ErrorStateAction(it.toString()))}
                        ),

                getView().onDropClickIntent()
                        .flatMap { dropLocalRepo(it) }
                        .subscribe(
                                { Log.e("dropped", it.name)  },
                                { dispatchAction(ErrorStateAction(it.toString())) }
                        )
        )
    }

    private fun getLocalRepos(): Observable<List<RepoModel>> {
        dispatchAction(LoadingStateAction())
        return getLocalReposUseCase
                    .createObservable(Unit)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
    }

    private fun dropLocalRepo(repoModel: RepoModel):
            Observable<RepoModel> = dropLocalReposUseCase
                    .createObservable(repoModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}
