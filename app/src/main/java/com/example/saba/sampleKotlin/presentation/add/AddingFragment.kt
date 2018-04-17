package com.example.saba.sampleKotlin.presentation.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.base.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_adding.view.*

class AddingFragment : BaseFragment<AddingPresenter>(), AddingView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adding, container, false)
        view.bvDrawResult.setOnClickListener { mPresenter.goToResultsScreen() }
        return view
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    companion object { @JvmStatic fun newInstance():AddingFragment = AddingFragment() }
}
