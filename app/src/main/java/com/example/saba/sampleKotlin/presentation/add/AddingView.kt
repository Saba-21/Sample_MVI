package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.mvi.view.BaseView
import io.reactivex.Observable

interface AddingView: BaseView<AddingViewState> {

    fun onResultNavigatorClickIntent(): Observable<Unit>

    fun onSearchClickIntent(): Observable<String>

}
