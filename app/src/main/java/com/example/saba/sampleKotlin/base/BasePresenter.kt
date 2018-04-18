package com.example.saba.sampleKotlin.base

import io.reactivex.disposables.CompositeDisposable

@Suppress("AddVarianceModifier")
open class BasePresenter<T : BaseView> {

    protected val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    var mView: T? = null

    fun attach(view: T) { mView = view }

    fun detach() {
        mView = null
        mCompositeDisposable.dispose()
        mCompositeDisposable.clear()
    }
}
