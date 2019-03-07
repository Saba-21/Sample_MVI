package com.example.saba.sampleMVI.domain.useCases

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.domain.repository.Repository
import com.example.saba.sampleMVI.base.useCase.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetLocalReposUseCase @Inject constructor(repository: Repository) :
        BaseUseCase<Unit, List<RepoModel>>(repository) {

    override fun createObservable(arg: Unit):
            Observable<List<RepoModel>> = repository.getLocalRepos()

}
