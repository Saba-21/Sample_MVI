package com.example.saba.sampleKotlin.presentation.get

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.base.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_result.view.*
import javax.inject.Inject

class ResultFragment : BaseFragment<ResultPresenter>(), ResultView{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        view.bvDrawAdding.setOnClickListener { mPresenter.goToAddingScreen() }
        mPresenter.attach(this)
        return view
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    companion object { @JvmStatic fun newInstance():ResultFragment = ResultFragment() }
}
