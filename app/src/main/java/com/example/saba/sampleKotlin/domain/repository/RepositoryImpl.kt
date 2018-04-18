package com.example.saba.sampleKotlin.domain.repository

import com.example.saba.sampleKotlin.domain.dataProvider.global.GlobalDataProvider
import com.example.saba.sampleKotlin.domain.model.RepoModel
import io.reactivex.Observable

class RepositoryImpl(private val globalDataProvider: GlobalDataProvider) : Repository {

    override fun getStarredRepos(userName: String):
            Observable<List<RepoModel>> = globalDataProvider.getStarredRepos(userName)

}
