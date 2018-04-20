package com.example.saba.sampleKotlin.mvi.presenter

import com.example.saba.sampleKotlin.mvi.actions.Action
import com.example.saba.sampleKotlin.mvi.actions.NavigatorAction
import com.example.saba.sampleKotlin.mvi.actions.ViewStateAction
import com.example.saba.sampleKotlin.mvi.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

abstract class BasePresenter<ViewState : Any, View : BaseView<ViewState>> {

    private var view: View? = null
    private var isFirstAttach: Boolean = true
    private var lastState: ViewState? = null
    private val viewStateSubject: PublishSubject<ViewState> = PublishSubject.create()
    private val continuousViewStateSubject: BehaviorSubject<ViewState> = BehaviorSubject.create()
    private val perPresenterDisposables: CompositeDisposable = CompositeDisposable()
    private val perViewDisposables: CompositeDisposable = CompositeDisposable()

    fun attach(view: View) {
        this.view = view
        if (isFirstAttach) lastState = getInitialViewState()
        continuousViewStateSubject.onNext(lastState!!)
        this.view!!.subscribe(continuousViewStateSubject, viewStateSubject)
        if (isFirstAttach) onFirstAttach()
        onAttach(isFirstAttach)
        isFirstAttach = false
    }

    fun detach(destroy: Boolean) {
        view = null
        onDetach()
        perViewDisposables.clear()
        if (destroy) {
            onDestroy()
            perPresenterDisposables.clear()
        }
    }

    protected fun dispatchAction(action: Action) {
        when (action) {
            is ViewStateAction<*> -> {
                @Suppress("UNCHECKED_CAST")
                val viewStateAction = action as (ViewStateAction<ViewState>)
                val viewState = viewStateAction.newState(lastState!!)
                if (viewStateAction.shouldBeSaved()) {
                    lastState = viewState
                    continuousViewStateSubject.onNext(lastState!!)
                } else {
                    viewStateSubject.onNext(viewState)
                }
            }
            is NavigatorAction<*> -> action.commitNavigatorAction()
        }
    }

    fun registerPerPresenterDisposables(vararg disposables: Disposable) {
        perPresenterDisposables.addAll(*disposables)
    }

    fun registerPerViewDisposables(vararg disposables: Disposable) {
        perViewDisposables.addAll(*disposables)
    }

    protected fun getView(): View = view!!

    abstract fun getInitialViewState(): ViewState

    abstract fun onFirstAttach()

    abstract fun onAttach(isFirstAttach: Boolean)

    protected fun onDetach() {}

    protected fun onDestroy() {}

}
