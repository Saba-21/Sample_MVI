package com.example.saba.sampleKotlin.base.mvi.views

import io.reactivex.Observable

interface BaseView<T : Any> {
    fun subscribe(viewStateObservable: Observable<T>)
}