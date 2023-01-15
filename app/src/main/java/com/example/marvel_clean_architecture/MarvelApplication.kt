package com.example.marvel_clean_architecture

import android.app.Application
import com.example.marvel_clean_architecture.framework.di.databaseModule
import com.example.marvel_clean_architecture.framework.di.marvelActionsModule
import com.example.marvel_clean_architecture.framework.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MarvelApplication)
            modules(listOf(networkModule, databaseModule, marvelActionsModule))
        }
    }

}