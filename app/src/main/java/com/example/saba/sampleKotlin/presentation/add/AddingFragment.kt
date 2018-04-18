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
import com.example.saba.sampleKotlin.domain.model.RepoModel
import com.zuluft.autoadapter.SortedAutoAdapter
import com.zuluft.generated.AutoAdapterFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_adding.view.*

class AddingFragment : BaseFragment<AddingPresenter>(), AddingView {

    private val listAdapter: SortedAutoAdapter = AutoAdapterFactory.createSortedAutoAdapter()
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adding, container, false)

        view.reposListView.layoutManager = LinearLayoutManager(context)
        view.reposListView.adapter = listAdapter

        mPresenter.attach(this)
        view.butDrawResult.setOnClickListener { mPresenter.goToResultsScreen() }
        view.butSearch.setOnClickListener { mPresenter.getStarredRepos(view.tvUsername.text.toString()) }

        return view
    }

    override fun updateList(repos: List<RepoModel>){
        listAdapter.updateAll(repos.map{RepoListRenderer(it)})
    }

    override fun onAttach(context: Context){
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    companion object { @JvmStatic fun newInstance():AddingFragment = AddingFragment() }
}
