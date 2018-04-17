package com.example.saba.sampleKotlin.base

@Suppress("AddVarianceModifier")
open class BasePresenter<T : BaseView> {

    var mView: T? = null

    fun attach(view: T) { mView = view }

    fun detach() { mView = null }
}
