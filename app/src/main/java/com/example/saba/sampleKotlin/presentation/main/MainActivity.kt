package com.example.saba.sampleKotlin.presentation.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.example.saba.sampleKotlin.R.id.frame_main
import com.example.saba.sampleKotlin.R.layout.activity_main
import com.example.saba.sampleKotlin.base.annotations.LayoutResourceId
import com.example.saba.sampleKotlin.base.mvi.activities.BaseActivity
import com.example.saba.sampleKotlin.presentation.add.AddingFragment
import com.example.saba.sampleKotlin.presentation.add.AddingFragment.Companion.ADDING_FRAGMENT_TAG
import com.example.saba.sampleKotlin.presentation.get.ResultFragment
import com.example.saba.sampleKotlin.presentation.get.ResultFragment.Companion.RESULT_FRAGMENT_TAG

@LayoutResourceId(activity_main)
class MainActivity : BaseActivity<MainViewState, MainPresenter>(), MainView {

    override fun reflectState(state: MainViewState) {
        when (state.state) {
            MAIN_VIEW_DRAW_ADDING_SCREEN_STATE -> onAddingScreenNavigationState()
            MAIN_VIEW_DRAW_RESULT_SCREEN_STATE -> onResultScreenNavigationState()
        }
    }

    override fun onPresenterReady(presenter: MainPresenter) {
        presenter.attach(this)
    }

    override fun renderView(savedInstanceState: Bundle?) {}

    private fun onResultScreenNavigationState() {
        supportFragmentManager
                .beginTransaction()
                .replace(frame_main, ResultFragment.newInstance(), RESULT_FRAGMENT_TAG)
                .addToBackStack(null)
                .commit()
    }

    private fun onAddingScreenNavigationState() {
        val fragment = supportFragmentManager.findFragmentById(frame_main)
        if (fragment == null)
            supportFragmentManager
                    .beginTransaction()
                    .replace(frame_main, AddingFragment.newInstance(), ADDING_FRAGMENT_TAG)
                    .commit()
        else
            onBackPressed()
    }

}
