package com.example.saba.sampleKotlin.presentation.get

import android.util.Log
import com.example.saba.sampleKotlin.base.BasePresenter
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.domain.useCase.DropLocalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.GetLocalReposUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResultPresenter(private val resultNavigator: ResultNavigator,
                      private val getLocalReposUseCase: GetLocalReposUseCase,
                      private val dropLocalReposUseCase: DropLocalReposUseCase):
        BasePresenter<ResultView>(){

    fun goToAddingScreen(){ resultNavigator.goToAddingScreen() }

    fun getLocalRepos(){

        mCompositeDisposable.add(getLocalReposUseCase
                .createObservable(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({mView?.updateList(it)},
                        { it.printStackTrace() }))
    }

    fun subscribeUserAction(userAction: Observable<RepoModel>){
        mCompositeDisposable.add(userAction
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { dropLocalRepo(it) }
                .subscribe{ log(it) })
    }

    private fun dropLocalRepo(repo: RepoModel):
            Observable<RepoModel> = dropLocalReposUseCase
            .createObservable(repo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun log(repo: RepoModel){ Log.e("clicked:", repo.name) }

}
