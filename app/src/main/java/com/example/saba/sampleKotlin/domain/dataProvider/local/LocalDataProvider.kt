package com.example.saba.sampleKotlin.domain.dataProvider.local

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import io.reactivex.Observable

interface LocalDataProvider{

    fun save(repoModel: RepoModel):Observable<RepoModel>

    fun drop(repoModel: RepoModel):Observable<RepoModel>

    fun select(): Observable<List<RepoModel>>
}
