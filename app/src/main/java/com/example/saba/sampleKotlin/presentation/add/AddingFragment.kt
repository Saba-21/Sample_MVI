package com.example.saba.sampleKotlin.presentation.add

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.adapter.RepoListRenderer
import com.example.saba.sampleKotlin.base.BaseFragment
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.jakewharton.rxbinding2.view.clicks
import com.zuluft.autoadapter.SortedAutoAdapter
import com.zuluft.generated.AutoAdapterFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_adding.view.*

class AddingFragment : BaseFragment<AddingPresenter>(), AddingView {

    private val listAdapter: SortedAutoAdapter = AutoAdapterFactory.createSortedAutoAdapter()

    companion object { @JvmStatic fun newInstance(): AddingFragment = AddingFragment() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adding, container, false)

        view.rvGlobalRepos.layoutManager = LinearLayoutManager(context)
        view.rvGlobalRepos.adapter = listAdapter

        mPresenter.attach(this)
        mPresenter.subscribeItemClick(listAdapter.clicks(RepoListRenderer::class.java ).map{ it.renderer }.map{ it.repoModel })
        mPresenter.subscribeNavigationClick(view.butDrawResult.clicks())
        mPresenter.subscribeSearchClick(view.butSearch.clicks().map { view.tvUsername.text.toString().trim() })

        return view
    }

    override fun onAttach(context: Context){
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun updateList(repos: List<RepoModel>){
        listAdapter.updateAll(repos.map{RepoListRenderer(it)})
    }
}
