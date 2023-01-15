package com.example.marvel_clean_architecture.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvel_clean_architecture.framework.database.dao.IMarvelDao
import com.example.marvel_clean_architecture.framework.datasource.local.model.MarvelResultEntity

@Database(
    entities = [
        MarvelResultEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): IMarvelDao
}