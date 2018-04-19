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

    fun subscribeNavigationClick(userAction: Observable<Unit>){
            mCompositeDisposable.add(userAction
                    .subscribe{addingNavigator.goToResultScreen()})
    }

    fun subscribeItemClick(userAction: Observable<RepoModel>){
            mCompositeDisposable.add(userAction
                    .flatMap { saveLocalRepo(it) }
                    .subscribe({ log(it) },
                            { it.printStackTrace() }))
    }

    fun subscribeSearchClick(userAction: Observable<String>){
            mCompositeDisposable.add(userAction
                    .flatMap { getGlobalRepos(it) }
                    .subscribe({ mView?.updateList(it) },
                            { it.printStackTrace() }))
    }

    private fun saveLocalRepo(repo: RepoModel):
            Observable<RepoModel> = saveLocalRepoUseCase
                    .createObservable(repo)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    private fun getGlobalRepos(userName: String):
            Observable<List<RepoModel>> = getGlobalReposUseCase
                    .createObservable(userName)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    private fun log(repo: RepoModel){ Log.i("clicked:", repo.name) }

}
