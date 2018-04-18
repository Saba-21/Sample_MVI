package com.example.saba.sampleKotlin.presentation.add

import android.util.Log
import com.example.saba.sampleKotlin.base.BasePresenter
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.domain.useCase.GetGlobalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.SaveLocalRepoUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddingPresenter(private val addingNavigator: AddingNavigator,
                      private val getGlobalReposUseCase: GetGlobalReposUseCase,
                      private val saveLocalRepoUseCase: SaveLocalRepoUseCase):
        BasePresenter<AddingView>(){

    fun goToResultsScreen(){addingNavigator.goToResultsScreen()}

    fun getGlobalRepos(userName: String){
        if (!userName.trim().isEmpty())
            mCompositeDisposable.add(getGlobalReposUseCase
                    .createObservable(userName)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ mView?.updateList(it) },
                            {it.printStackTrace()}))
    }

    fun subscribeUserAction(userAction: Observable<RepoModel>){
        mCompositeDisposable.add(userAction
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { saveLocalRepo(it) }
                .subscribe{ log(it) })
    }

    private fun saveLocalRepo(repo: RepoModel):
            Observable<RepoModel> = saveLocalRepoUseCase
            .createObservable(repo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun log(repo: RepoModel){ Log.e("clicked:", repo.name) }

}
