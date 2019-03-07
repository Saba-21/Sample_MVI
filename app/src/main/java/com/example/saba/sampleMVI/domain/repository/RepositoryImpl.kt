package com.example.saba.sampleMVI.domain.repository

import com.example.saba.sampleMVI.domain.dataProvider.global.GlobalDataProvider
import com.example.saba.sampleMVI.domain.dataProvider.local.LocalDataProvider
import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import io.reactivex.Observable

class RepositoryImpl(private val globalDataProvider: GlobalDataProvider,
                     private val localDataProvider: LocalDataProvider) : Repository {

    override fun saveLocalRepo(repoModel: RepoModel):
            Observable<RepoModel> = localDataProvider.save(repoModel)

    override fun dropLocalRepos(repoModel: RepoModel):
            Observable<RepoModel> = localDataProvider.drop(repoModel)

    override fun getLocalRepos():
            Observable<List<RepoModel>> = localDataProvider.select()

    override fun getGlobalRepos(userName: String):
            Observable<List<RepoModel>> = globalDataProvider.getStarredRepos(userName)

}
