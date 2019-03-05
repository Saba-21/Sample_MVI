package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.base.mvi.views.BaseView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface AddingView : BaseView<AddingViewState> {

    fun onResultNavigatorClickIntent(): Observable<Unit>

    fun onSearchClickIntent(): Observable<String>

    fun onAddClickIntent(): PublishSubject<RepoModel>

}
