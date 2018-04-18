package com.example.saba.sampleKotlin.domain.repository

import com.example.saba.sampleKotlin.domain.model.RepoModel
import io.reactivex.Observable

interface Repository {

    fun getStarredRepos(userName: String): Observable<List<RepoModel>>

}