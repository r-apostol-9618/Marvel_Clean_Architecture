package com.example.marvel_clean_architecture.framework.di

import com.example.marvel_clean_architecture.data.datasource.local.IMarvelLocalSource
import com.example.marvel_clean_architecture.data.datasource.remote.IMarvelRemoteSource
import com.example.marvel_clean_architecture.data.repository.MarvelRepositoryImpl
import com.example.marvel_clean_architecture.domain.repository.IMarvelRepository
import com.example.marvel_clean_architecture.domain.usecase.FetchAndObserveMarvelUseCaseFromCacheImpl
import com.example.marvel_clean_architecture.domain.usecase.FetchAndObserveMarvelUseCaseImpl
import com.example.marvel_clean_architecture.domain.usecase.IFetchAndObserveMarvelFromCacheUseCase
import com.example.marvel_clean_architecture.domain.usecase.IFetchAndObserveMarvelUseCase
import com.example.marvel_clean_architecture.framework.datasource.local.datasource.MarvelLocalSourceImpl
import com.example.marvel_clean_architecture.framework.datasource.remote.datasource.MarvelRemoteSourceImpl
import com.example.marvel_clean_architecture.presentation.viewModel.MarvelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val marvelActionsModule = module {
    single { FetchAndObserveMarvelUseCaseImpl(get()) } bind IFetchAndObserveMarvelUseCase::class
    single { FetchAndObserveMarvelUseCaseFromCacheImpl(get()) } bind IFetchAndObserveMarvelFromCacheUseCase::class
    single { MarvelRepositoryImpl(get(), get()) } bind IMarvelRepository::class
    single { MarvelRemoteSourceImpl(get()) } bind IMarvelRemoteSource::class
    single { MarvelLocalSourceImpl(get()) } bind IMarvelLocalSource::class
    viewModel { MarvelViewModel() }
}