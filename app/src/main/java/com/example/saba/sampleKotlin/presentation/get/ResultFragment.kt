package com.example.saba.sampleKotlin.presentation.get

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.mvi.fragment.BaseFragment
import com.jakewharton.rxbinding2.view.clicks
import com.zuluft.autoadapter.SortedAutoAdapter
import com.zuluft.generated.AutoAdapterFactory
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.android.synthetic.main.fragment_result.view.*

class ResultFragment : BaseFragment<ResultViewState, ResultPresenter>(), ResultView {

    private val listAdapter: SortedAutoAdapter = AutoAdapterFactory.createSortedAutoAdapter()

    companion object { @JvmStatic fun newInstance(): ResultFragment = ResultFragment() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        view.rvLocalRepos.layoutManager = LinearLayoutManager(context)
        view.rvLocalRepos.adapter = listAdapter

        return view
    }

    override fun renderView(view: View?, savedInstanceState: Bundle?) {
    }

    override fun reflectState(state: ResultViewState) {
    }

    override fun onPresenterReady(presenter: ResultPresenter) {
        presenter.attach(this)
    }

    override fun onAddingScreenNavigatorClickIntent(): Observable<Unit>  = bvDrawAdding.clicks()

}
