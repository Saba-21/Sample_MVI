package com.example.saba.sampleKotlin.presentation.add

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
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
import kotlinx.android.synthetic.main.fragment_adding.*
import kotlinx.android.synthetic.main.fragment_adding.view.*

class AddingFragment : BaseFragment<AddingViewState, AddingPresenter>(), AddingView {

    private val listAdapter: SortedAutoAdapter = AutoAdapterFactory.createSortedAutoAdapter()

    companion object { @JvmStatic fun newInstance(): AddingFragment = AddingFragment() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adding, container, false)

        view.rvGlobalRepos.layoutManager = LinearLayoutManager(context)
        view.rvGlobalRepos.adapter = listAdapter

        return view
    }

    override fun renderView(view: View?, savedInstanceState: Bundle?) {
    }

    override fun reflectState(state: AddingViewState) {
        when(state.state){

            ADDING_VIEW_INITIAL_STATE -> {
                bar_loading.visibility = View.GONE
                tv_error.visibility = View.GONE
            }

            ADDING_VIEW_LOADING_STATE -> {
                listAdapter.removeAll()
                bar_loading.visibility = View.VISIBLE
            }

            ADDING_VIEW_SUCCESS_STATE -> {
                bar_loading.visibility = View.GONE
                listAdapter.updateAll(state.result?.map { repoModel: RepoModel -> RepoListRenderer(repoModel) }!!)
            }

            ADDING_VIEW_ERROR_STATE -> {
                bar_loading.visibility = View.GONE
                tv_error.visibility = View.VISIBLE
                tv_error.text = state.exception
            }

        }
    }

    override fun onPresenterReady(presenter: AddingPresenter) {
        presenter.attach(this)
    }

    override fun onResultNavigatorClickIntent():
            Observable<Unit> = butDrawResult.clicks()

    override fun onSearchClickIntent():
            Observable<String> = butSearch.clicks().map { tvUsername.text.toString().trim() }

}
