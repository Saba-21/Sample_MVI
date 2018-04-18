package com.example.saba.sampleKotlin.domain.useCase

import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.domain.repository.Repository
import com.example.saba.sampleKotlin.domain.useCase.base.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class DropLocalReposUseCase @Inject constructor(repository: Repository) :
        BaseUseCase<RepoModel, RepoModel>(repository) {

    override fun createObservable(arg: RepoModel):
            Observable<RepoModel> = repository.dropLocalRepos(arg)

}
