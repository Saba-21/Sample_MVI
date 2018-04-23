package com.example.saba.sampleKotlin.presentation.add

import android.util.Log
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.mvi.presenter.BasePresenter
import com.example.saba.sampleKotlin.domain.useCase.GetGlobalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.SaveLocalRepoUseCase
import com.example.saba.sampleKotlin.presentation.add.actions.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddingPresenter(private val addingNavigator: AddingNavigator,
                      private val getGlobalReposUseCase: GetGlobalReposUseCase,
                      private val saveLocalRepoUseCase: SaveLocalRepoUseCase):
        BasePresenter<AddingViewState, AddingView>(){

    override fun getInitialViewState():
            AddingViewState = AddingViewState(ADDING_VIEW_INITIAL_STATE,null, null)

    override fun onFirstAttach() { }

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(
                getView().onResultNavigatorClickIntent()
                        .map { GoToResultScreenAction(addingNavigator) }
                        .subscribe(this::dispatchAction)
                )

        registerPerPresenterDisposables(
                getView().onSearchClickIntent()
                        .flatMap{ getGlobalRepos(it)}
                        .subscribe(
                                { dispatchAction(ResponseSuccessStateAction(it)) },
                                { dispatchAction(ErrorStateAction(it.toString())) }
                        ),

                getView().onAddClickIntent()
                        .flatMap { addLocalRepo(it) }
                        .subscribe(
                                { Log.e("added", it.name)  },
                                { dispatchAction(ErrorStateAction(it.toString())) }
                        )
        )
    }

    private fun getGlobalRepos(username: String): Observable<List<RepoModel>> {
        dispatchAction(LoadingStateAction())
        return getGlobalReposUseCase
                    .createObservable(username)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
    }

    private fun addLocalRepo(repoModel: RepoModel):
            Observable<RepoModel> = saveLocalRepoUseCase
                    .createObservable(repoModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}
