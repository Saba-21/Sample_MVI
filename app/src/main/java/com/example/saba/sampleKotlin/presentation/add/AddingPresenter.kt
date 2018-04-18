package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.base.BasePresenter
import com.example.saba.sampleKotlin.domain.dataProvider.global.GlobalDataProvider
import com.example.saba.sampleKotlin.domain.useCase.GetStarredReposUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddingPresenter(private val addingNavigator: AddingNavigator,
                      private val getStarredReposUseCase: GetStarredReposUseCase):
        BasePresenter<AddingView>(){

    fun goToResultsScreen(){addingNavigator.goToResultsScreen()}

    fun getStarredRepos(userName: String){
        if (!userName.trim().isEmpty())
            getStarredReposUseCase.createObservable(userName)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{mView?.updateList(it)}
    }

}
