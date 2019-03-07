package com.example.saba.sampleKotlin.base.mvi.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saba.sampleKotlin.base.annotations.LayoutResourceId
import com.example.saba.sampleKotlin.base.mvi.presenters.BasePresenter
import com.example.saba.sampleKotlin.base.mvi.views.BaseView
import dagger.Lazy
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@Suppress("unused")
abstract class BaseFragment<V : Any, P : BasePresenter<V, out BaseView<V>>> : Fragment() {

    private var compositeDisposable: CompositeDisposable? = null
    private var presenter: P? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        compositeDisposable = CompositeDisposable()
        var view: View? = null
        val layoutResourceId = javaClass.getAnnotation(LayoutResourceId::class.java)
        if (layoutResourceId != null) {
            view = inflater.inflate(layoutResourceId.value, container, false)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderView(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    @Suppress("unused")
    fun subscribe(viewStateObservable: Observable<V>) {
        compositeDisposable!!.add(viewStateObservable.subscribe(this::reflectState))
    }

    @Suppress("UNCHECKED_CAST", "unused")
    @Inject
    fun setPresenter(lazy: Lazy<P>) {
        if (presenter == null) {
            presenter = lazy.get()
        }
        onPresenterReady(presenter!!)
    }

    fun getPresenter(): P {
        return presenter!!
    }

    override fun onDestroyView() {
        presenter?.detach(false)
        if (compositeDisposable != null) {
            compositeDisposable!!.dispose()
            compositeDisposable!!.clear()
        }
        super.onDestroyView()
    }

    override fun onDestroy() {
        presenter?.detach(true)
        super.onDestroy()
    }

    protected abstract fun renderView(view: View?, savedInstanceState: Bundle?)

    protected abstract fun reflectState(state: V)

    protected abstract fun onPresenterReady(presenter: P)

}