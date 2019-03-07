package com.example.saba.sampleMVI.presentation.get

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.base.structure.views.BaseView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface ResultView: BaseView<ResultViewState> {

    fun onAddingNavigatorClickIntent(): Observable<Unit>

    fun onDropClickIntent(): PublishSubject<RepoModel>

}
