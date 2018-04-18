package com.example.saba.sampleKotlin.domain.useCase

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.domain.repository.Repository
import com.example.saba.sampleKotlin.domain.useCase.base.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetLocalReposUseCase @Inject constructor(repository: Repository) :
        BaseUseCase<Unit, List<RepoModel>>(repository) {

    override fun createObservable(arg: Unit):
            Observable<List<RepoModel>> = repository.getLocalRepos()

}
