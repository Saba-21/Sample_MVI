package com.example.saba.sampleMVI.base.structure.views

import io.reactivex.Observable

interface BaseView<T : Any> {
    fun subscribe(viewStateObservable: Observable<T>)
}