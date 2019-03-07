package com.example.saba.sampleMVI.presentation.add

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.saba.sampleMVI.R.layout.fragment_adding
import com.example.saba.sampleMVI.custom.adapter.RepoAdapter
import com.example.saba.sampleMVI.base.annotations.LayoutResourceId
import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.base.structure.fragments.BaseFragment
import com.example.saba.sampleMVI.custom.HIDE_LOADER_STATE
import com.example.saba.sampleMVI.custom.SHOW_ERROR_STATE
import com.example.saba.sampleMVI.custom.SHOW_LOADER_STATE
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_adding.*

@LayoutResourceId(fragment_adding)
class AddingFragment : BaseFragment<AddingViewState, AddingPresenter>(), AddingView {

    private val listAdapter = RepoAdapter()
    private val listItemClickListener = PublishSubject.create<RepoModel>()

    override fun renderView(view: View?, savedInstanceState: Bundle?) {
        rvGlobalRepos.layoutManager = LinearLayoutManager(context)
        rvGlobalRepos.adapter = listAdapter
        listAdapter.setClickListener {
            listItemClickListener.onNext(it)
        }
    }

    override fun reflectState(state: AddingViewState) {
        when (state.state) {
            SHOW_LOADER_STATE -> showLoader()
            DRAW_REPO_LIST_STATE -> drawRepoList(state)
            SHOW_ERROR_STATE -> showError(state)
            HIDE_LOADER_STATE -> hideLoader()
        }
    }

    private fun drawRepoList(viewState: AddingViewState) {
        listAdapter.updateData(viewState.response!!)
    }

    private fun showError(viewState: AddingViewState) {
        tv_adding_error.visibility = View.VISIBLE
        tv_adding_error.text = viewState.exception
    }

    private fun showLoader() {
        animLoading.playAnimation()
        animLoading.visibility = View.VISIBLE
    }

    private fun hideLoader() {
        animLoading.cancelAnimation()
        animLoading.visibility = View.GONE
    }

    override fun onPresenterReady(presenter: AddingPresenter) {
        presenter.attach(this)
    }

    override fun onResultNavigatorClickIntent():
            Observable<Unit> = butDrawResult.clicks()

    override fun onSearchClickIntent():
            Observable<String> = butSearch.clicks().map { tvUsername.text.toString().trim() }

    override fun onAddClickIntent():
            PublishSubject<RepoModel> = listItemClickListener

    companion object {
        const val ADDING_FRAGMENT_TAG = "ADDING_FRAGMENT_TAG"
        @JvmStatic
        fun newInstance(): AddingFragment = AddingFragment()
    }

}