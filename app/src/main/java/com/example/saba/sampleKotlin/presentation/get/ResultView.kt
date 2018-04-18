package com.example.saba.sampleKotlin.presentation.get

import com.example.saba.sampleKotlin.base.BaseView
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel

interface ResultView :BaseView{

    fun updateList(repos: List<RepoModel>)

}
