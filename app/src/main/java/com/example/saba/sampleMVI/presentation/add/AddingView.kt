package com.example.saba.sampleMVI.presentation.add

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.base.structure.views.BaseView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface AddingView : BaseView<AddingViewState> {

    fun onResultNavigatorClickIntent(): Observable<Unit>

    fun onSearchClickIntent(): Observable<String>

    fun onAddClickIntent(): PublishSubject<RepoModel>

}
