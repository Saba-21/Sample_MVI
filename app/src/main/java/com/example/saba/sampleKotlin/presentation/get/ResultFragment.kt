package com.example.saba.sampleKotlin.presentation.get

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.saba.sampleKotlin.R.layout.fragment_result
import com.example.saba.sampleKotlin.adapter.RepoAdapter
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.mvi.anotations.LayoutResourceId
import com.example.saba.sampleKotlin.mvi.fragment.BaseFragment
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_result.*

@LayoutResourceId(fragment_result)
class ResultFragment : BaseFragment<ResultViewState, ResultPresenter>(), ResultView {

    private val listAdapter = RepoAdapter()
    private val listItemClickListener = PublishSubject.create<RepoModel>()

    companion object {
        @JvmStatic
        fun newInstance(): ResultFragment = ResultFragment()
    }

    override fun reflectState(state: ResultViewState) {
        when (state.state) {
            RESULT_VIEW_INITIAL_STATE -> initialStateActions()
            RESULT_VIEW_LOADING_STATE -> loadingStateActions()
            RESULT_VIEW_SUCCESS_STATE -> successStateActions(state)
            RESULT_VIEW_ERROR_STATE -> errorStateActions(state)
        }
    }

    private fun initialStateActions() {
        rvLocalRepos.layoutManager = LinearLayoutManager(context)
        rvLocalRepos.adapter = listAdapter
        listAdapter.setClickListener {
            listItemClickListener.onNext(it)
        }
    }

    private fun loadingStateActions() {
        startLoadingAnimation()
    }

    private fun successStateActions(viewState: ResultViewState) {
        listAdapter.updateData(viewState.response!!)
        stopLoadingAnimation()
    }

    private fun errorStateActions(viewState: ResultViewState) {
        tv_result_error.visibility = View.VISIBLE
        tv_result_error.text = viewState.exception
        stopLoadingAnimation()
    }

    private fun startLoadingAnimation() {
        animLoading.playAnimation()
        animLoading.visibility = View.VISIBLE
    }

    private fun stopLoadingAnimation() {
        animLoading.cancelAnimation()
        animLoading.visibility = View.GONE
    }

    override fun renderView(view: View?, savedInstanceState: Bundle?) {}

    override fun onPresenterReady(presenter: ResultPresenter) {
        presenter.attach(this)
    }

    override fun onAddingNavigatorClickIntent():
            Observable<Unit> = butDrawAdding.clicks()

    override fun onInitialIntent():
            Observable<Unit> = Observable.just(Unit)

    override fun onDropClickIntent():
            PublishSubject<RepoModel> = listItemClickListener

}