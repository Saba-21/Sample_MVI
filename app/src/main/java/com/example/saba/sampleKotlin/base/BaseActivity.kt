package com.example.saba.sampleKotlin.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<P : BasePresenter<out BaseView>> : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject lateinit var mPresenter: P

    override fun onDestroy() {
        mPresenter.detach()
        super.onDestroy()
    }

    @Inject lateinit var mDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = mDispatchingAndroidInjector

}
