package com.example.saba.sampleKotlin.domain.repository

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import io.reactivex.Observable

interface Repository {

    fun getGlobalRepos(userName: String): Observable<List<RepoModel>>

    fun getLocalRepos(): Observable<List<RepoModel>>

    fun dropLocalRepos(repoModel: RepoModel): Observable<RepoModel>

    fun saveLocalRepo(repoModel: RepoModel): Observable<RepoModel>
}
