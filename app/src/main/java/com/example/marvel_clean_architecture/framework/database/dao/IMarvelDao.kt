package com.example.marvel_clean_architecture.framework.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel_clean_architecture.framework.datasource.local.model.MarvelResultEntity

@Dao
interface IMarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg posts: MarvelResultEntity)

    @Query("SELECT * FROM ${MarvelResultEntity.TABLE_NAME}")
    suspend fun getAll(): List<MarvelResultEntity>
}