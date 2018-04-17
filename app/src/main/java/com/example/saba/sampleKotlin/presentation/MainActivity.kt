package com.example.saba.sampleKotlin.presentation

import android.os.Bundle
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.base.BaseActivity
import com.example.saba.sampleKotlin.presentation.add.AddingFragment
import com.example.saba.sampleKotlin.presentation.get.ResultFragment
import dagger.android.AndroidInjection

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.attach(this)
        mPresenter.goToAddingScreen()
    }

    override fun drawResultFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_main, ResultFragment.newInstance())
                .commit()
    }

    override fun drawAddingFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_main, AddingFragment.newInstance())
                .commit()
    }
}
