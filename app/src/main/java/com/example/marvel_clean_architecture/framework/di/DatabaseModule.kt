package com.example.marvel_clean_architecture.framework.di

import androidx.room.Room
import com.example.marvel_clean_architecture.framework.database.MarvelDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MarvelDatabase::class.java,
            "MarvelDatabase"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<MarvelDatabase>().marvelDao() }
}