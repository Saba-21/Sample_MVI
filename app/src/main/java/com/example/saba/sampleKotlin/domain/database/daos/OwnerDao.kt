package com.example.saba.sampleKotlin.domain.database.daos

import android.arch.persistence.room.*
import com.example.saba.sampleKotlin.domain.model.dbModels.OwnerDbModel

@Dao
interface OwnerDao {

    @Query("Select * From owner")
    fun select(): List<OwnerDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(owner: OwnerDbModel)

    @Delete
    fun drop(owner: OwnerDbModel)

}
