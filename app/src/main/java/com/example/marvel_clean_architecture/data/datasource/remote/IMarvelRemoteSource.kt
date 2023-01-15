package com.example.marvel_clean_architecture.data.datasource.remote

import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain

interface IMarvelRemoteSource {

    suspend fun getAll(): List<MarvelCharactersDomain>

}