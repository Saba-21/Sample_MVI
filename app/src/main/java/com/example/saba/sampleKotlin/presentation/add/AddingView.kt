package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.base.BaseView
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel

interface AddingView: BaseView{

    fun updateList(repos: List<RepoModel>)

}
