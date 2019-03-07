package com.example.saba.sampleMVI.domain.dataProvider.local

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import io.reactivex.Observable

interface LocalDataProvider{

    fun save(repoModel: RepoModel):Observable<RepoModel>

    fun drop(repoModel: RepoModel):Observable<RepoModel>

    fun select(): Observable<List<RepoModel>>
}
