package com.example.saba.sampleMVI.domain.useCases

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.domain.repository.Repository
import com.example.saba.sampleMVI.base.useCase.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetGlobalReposUseCase @Inject constructor(repository: Repository) :
        BaseUseCase<String, List<RepoModel>>(repository) {

    override fun createObservable(arg: String):
            Observable<List<RepoModel>> = repository.getGlobalRepos(arg)

}
