package com.example.saba.sampleMVI.custom.helper

import com.example.saba.sampleMVI.domain.models.apiModels.OwnerModel
import com.example.saba.sampleMVI.domain.models.apiModels.RepoModel
import com.example.saba.sampleMVI.domain.models.dbModels.OwnerDbModel
import com.example.saba.sampleMVI.domain.models.dbModels.RepoDbModel

class Converter {

    fun toRepoDbModel(repo: RepoModel):
            RepoDbModel = RepoDbModel(repo.id, repo.name, repo.language, repo.starCount,repo.owner.id)

    fun toOwnerDbModel(repo: RepoModel):
            OwnerDbModel = OwnerDbModel(repo.id, repo.owner.login, repo.owner.avatarUrl)

    private fun convertModel(repo: RepoDbModel, owner: OwnerDbModel):
            RepoModel = RepoModel(repo.id, repo.name, repo.language, repo.starCount, OwnerModel(owner.id, owner.name, owner.avatarUrl))

    fun convertList(repos: List<RepoDbModel>, owners: List<OwnerDbModel>): List<RepoModel>{
        val repoList: MutableList<RepoModel> = arrayListOf()
        repos.forEach { repoList.add(convertModel(it, owners[owners.indexOfFirst{ owner -> owner.id == it.id }])) }
        return repoList
    }
}
