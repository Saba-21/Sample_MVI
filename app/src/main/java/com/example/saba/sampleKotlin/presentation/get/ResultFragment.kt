package com.example.saba.sampleKotlin.presentation.get

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
import com.zuluft.autoadapter.SortedAutoAdapter
import com.zuluft.generated.AutoAdapterFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_result.view.*

class ResultFragment : BaseFragment<ResultPresenter>(), ResultView{

    private val listAdapter: SortedAutoAdapter = AutoAdapterFactory.createSortedAutoAdapter()

    companion object { @JvmStatic fun newInstance(): ResultFragment = ResultFragment() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        view.rvLocalRepos.layoutManager = LinearLayoutManager(context)
        view.rvLocalRepos.adapter = listAdapter

        mPresenter.attach(this)
        mPresenter.subscribeUserAction(listAdapter.clicks(RepoListRenderer::class.java ).map{ it.renderer }.map{ it.repoModel })

        view.bvDrawAdding.setOnClickListener { mPresenter.goToAddingScreen() }
        mPresenter.getLocalRepos()

        return view
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun updateList(repos: List<RepoModel>){
        listAdapter.updateAll(repos.map{RepoListRenderer(it)})
    }
}
