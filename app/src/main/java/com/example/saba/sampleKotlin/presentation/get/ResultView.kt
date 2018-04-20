package com.example.saba.sampleKotlin.presentation.get

import com.example.saba.sampleKotlin.mvi.view.BaseView
import io.reactivex.Observable

interface ResultView : BaseView<ResultViewState> {

    fun onAddingScreenNavigatorClickIntent(): Observable<Unit>

}
