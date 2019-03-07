package com.example.saba.sampleMVI.domain.useCases

import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.domain.repository.Repository
import com.example.saba.sampleMVI.base.useCase.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class SaveLocalRepoUseCase @Inject constructor(repository: Repository) :
        BaseUseCase<RepoModel, RepoModel>(repository) {

    override fun createObservable(arg: RepoModel):
            Observable<RepoModel> = repository.saveLocalRepo(arg)

}
