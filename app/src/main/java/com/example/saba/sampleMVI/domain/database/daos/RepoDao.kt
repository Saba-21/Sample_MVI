package com.example.saba.sampleMVI.domain.database.daos

import android.arch.persistence.room.*
import com.example.saba.sampleMVI.domain.models.dbModels.RepoDbModel
import io.reactivex.Flowable

@Dao
interface RepoDao {

    @Query("Select * From repository")
    fun select(): Flowable<List<RepoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: RepoDbModel)

    @Delete
    fun drop(repo: RepoDbModel)

}
