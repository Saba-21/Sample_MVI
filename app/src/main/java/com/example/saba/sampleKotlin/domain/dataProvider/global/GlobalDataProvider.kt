package com.example.saba.sampleKotlin.domain.dataProvider.global

import com.example.saba.sampleKotlin.domain.model.RepoModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GlobalDataProvider {

    @GET("users/{user}/starred")
    fun getStarredRepos(@Path("user")userName: String): Observable<List<RepoModel>>

}