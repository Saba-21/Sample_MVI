package com.example.saba.sampleKotlin.domain.useCase

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.domain.repository.Repository
import com.example.saba.sampleKotlin.domain.useCase.base.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetGlobalReposUseCase @Inject constructor(repository: Repository) :
        BaseUseCase<String, List<RepoModel>>(repository) {

    override fun createObservable(arg: String):
            Observable<List<RepoModel>> = repository.getGlobalRepos(arg)

}
