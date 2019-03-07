package com.example.saba.sampleMVI.base.structure.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.saba.sampleMVI.base.annotations.LayoutResourceId
import com.example.saba.sampleMVI.base.structure.presenters.BasePresenter
import com.example.saba.sampleMVI.base.structure.views.BaseView
import dagger.Lazy
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@Suppress("unused")
abstract class BaseActivity<V : Any, P : BasePresenter<V, out BaseView<V>>> :
        AppCompatActivity(), HasSupportFragmentInjector {

    private var presenter: P? = null
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        val layoutResourceId = javaClass.getAnnotation(LayoutResourceId::class.java)
        if (layoutResourceId != null) {
            setContentView(layoutResourceId.value)
        }
        renderView(savedInstanceState)
        AndroidInjection.inject(this)
    }

    @Suppress("UNCHECKED_CAST")
    @Inject
    fun setPresenter(lazy: Lazy<P>) {
        presenter = if (lastNonConfigurationInstance == null)
            lazy.get()
        else
            lastCustomNonConfigurationInstance as P

        onPresenterReady(presenter!!)
    }

    fun getPresenter(): P {
        return presenter!!
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter!!
    }

    @Suppress("unused")
    fun subscribe(viewStateObservable: Observable<V>) {
        compositeDisposable!!.add(viewStateObservable.subscribe(this::reflectState))
    }

    override fun onDestroy() {
        presenter!!.detach(isFinishing)
        if (compositeDisposable != null) {
            compositeDisposable!!.dispose()
            compositeDisposable!!.clear()
        }
        super.onDestroy()
    }

    protected fun registerDisposables(vararg disposables: Disposable) {
        compositeDisposable!!.addAll(*disposables)
    }

    protected abstract fun reflectState(state: V)

    protected abstract fun onPresenterReady(presenter: P)

    protected abstract fun renderView(savedInstanceState: Bundle?)

    @Inject
    lateinit var mDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = mDispatchingAndroidInjector

}