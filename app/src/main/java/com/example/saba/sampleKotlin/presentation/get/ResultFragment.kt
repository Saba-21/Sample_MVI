package com.example.saba.sampleKotlin.presentation.get

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.saba.sampleKotlin.R.layout.fragment_result
import com.example.saba.sampleKotlin.custom.adapter.RepoAdapter
import com.example.saba.sampleKotlin.base.annotations.LayoutResourceId
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.base.mvi.fragments.BaseFragment
import com.example.saba.sampleKotlin.custom.HIDE_LOADER_STATE
import com.example.saba.sampleKotlin.custom.SHOW_ERROR_STATE
import com.example.saba.sampleKotlin.custom.SHOW_LOADER_STATE
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_result.*

@LayoutResourceId(fragment_result)
class ResultFragment : BaseFragment<ResultViewState, ResultPresenter>(), ResultView {

    private val listAdapter = RepoAdapter()
    private val listItemClickListener = PublishSubject.create<RepoModel>()

    override fun renderView(view: View?, savedInstanceState: Bundle?) {
        rvLocalRepos.layoutManager = LinearLayoutManager(context)
        rvLocalRepos.adapter = listAdapter
        listAdapter.setClickListener {
            listItemClickListener.onNext(it)
        }
    }

    override fun reflectState(state: ResultViewState) {
        when (state.state) {
            SHOW_LOADER_STATE -> showLoader()
            DRAW_REPO_LIST_STATE -> drawRepoList(state)
            SHOW_ERROR_STATE -> showError(state)
            HIDE_LOADER_STATE -> hideLoader()
        }
    }

    private fun drawRepoList(viewState: ResultViewState) {
        listAdapter.updateData(viewState.response!!)
    }

    private fun showError(viewState: ResultViewState) {
        tv_result_error.visibility = View.VISIBLE
        tv_result_error.text = viewState.exception
    }

    private fun showLoader() {
        animLoading.playAnimation()
        animLoading.visibility = View.VISIBLE
    }

    private fun hideLoader() {
        animLoading.cancelAnimation()
        animLoading.visibility = View.GONE
    }

    override fun onPresenterReady(presenter: ResultPresenter) {
        presenter.attach(this)
    }

    override fun onAddingNavigatorClickIntent():
            Observable<Unit> = butDrawAdding.clicks()

    override fun onDropClickIntent():
            PublishSubject<RepoModel> = listItemClickListener

    companion object {
        const val RESULT_FRAGMENT_TAG = "RESULT_FRAGMENT_TAG"
        @JvmStatic
        fun newInstance(): ResultFragment = ResultFragment()
    }

}