package com.example.saba.sampleMVI.domain.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.saba.sampleMVI.domain.database.daos.RepoDao
import com.example.saba.sampleMVI.domain.database.daos.OwnerDao
import com.example.saba.sampleMVI.domain.models.dbModels.OwnerDbModel
import com.example.saba.sampleMVI.domain.models.dbModels.RepoDbModel

@Database(entities = [RepoDbModel::class, OwnerDbModel::class],
        version = 1,
        exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {

    abstract fun repoDao():RepoDao

    abstract fun ownerDao():OwnerDao

}
