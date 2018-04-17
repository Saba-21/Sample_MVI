package com.example.saba.sampleKotlin.base

import android.support.v4.app.Fragment
import javax.inject.Inject

abstract class BaseFragment<P : BasePresenter<out BaseView>> : Fragment(){

    @Inject lateinit var mPresenter: P

    override fun onDestroyView() {
        mPresenter.detach()
        super.onDestroyView()
    }
}
