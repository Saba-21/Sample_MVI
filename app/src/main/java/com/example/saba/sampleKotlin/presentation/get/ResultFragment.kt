package com.example.saba.sampleKotlin.presentation.get

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.adapter.RepoListRenderer
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
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

    override fun reflectState(state: ResultViewState) {
        when(state.state){
            RESULT_VIEW_INITIAL_STATE -> initialStateActions()
            RESULT_VIEW_LOADING_STATE -> loadingStateActions()
            RESULT_VIEW_SUCCESS_STATE -> successStateActions(state)
            RESULT_VIEW_ERROR_STATE -> errorStateActions(state)
        }
    }

    private fun initialStateActions(){
        bar_result_loading.visibility = View.GONE
        tv_result_error.visibility = View.GONE
    }

    private fun loadingStateActions(){
        listAdapter.removeAll()
        bar_result_loading.visibility = View.VISIBLE
    }

    private fun successStateActions(viewState: ResultViewState){
        bar_result_loading.visibility = View.GONE
        listAdapter.updateAll(viewState.response?.map{ RepoListRenderer(it) }!!)
    }

    private fun errorStateActions(viewState: ResultViewState){
        bar_result_loading.visibility = View.GONE
        tv_result_error.visibility = View.VISIBLE
        tv_result_error.text = viewState.exception
    }

    override fun renderView(view: View?, savedInstanceState: Bundle?) { }

    override fun onPresenterReady(presenter: ResultPresenter) { presenter.attach(this) }

    override fun onAddingNavigatorClickIntent():
            Observable<Unit> = butDrawAdding.clicks()

    override fun onInitialIntent():
            Observable<Unit>  = Observable.just(Unit)

    override fun onDropClickIntent():
            Observable<RepoModel> = listAdapter
                    .clicks(RepoListRenderer::class.java)
                    .map{itemInfo->itemInfo.renderer}
                    .map{renderer->renderer.repoModel}
}
