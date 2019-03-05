package com.example.saba.sampleKotlin.domain.dataProvider.local

import com.example.saba.sampleKotlin.domain.database.RepoDatabase
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.example.saba.sampleKotlin.custom.helper.Converter
import io.reactivex.Observable

class LocalDataProviderImpl(private val repoDb: RepoDatabase): LocalDataProvider {

    override fun select():
            Observable<List<RepoModel>> = repoDb.repoDao().select()
            .map { Converter().convertList(it, repoDb.ownerDao().select()) }
            .toObservable()

    override fun drop(repoModel: RepoModel):
            Observable<RepoModel> = Observable.fromCallable{ dropData(repoModel) }

    override fun save(repoModel: RepoModel):
            Observable<RepoModel> = Observable.fromCallable{ saveData(repoModel) }

    private fun dropData(repoModel: RepoModel): RepoModel{
        repoDb.repoDao().drop(Converter().toRepoDbModel(repoModel))
        repoDb.ownerDao().drop(Converter().toOwnerDbModel(repoModel))
        return repoModel
    }

    private fun saveData(repoModel: RepoModel): RepoModel{
        repoDb.ownerDao().insert(Converter().toOwnerDbModel(repoModel))
        repoDb.repoDao().insert(Converter().toRepoDbModel(repoModel))
        return repoModel
    }


}
