package com.example.marvel_clean_architecture.framework.datasource.remote.datasource

import com.example.marvel_clean_architecture.data.datasource.remote.IMarvelRemoteSource
import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain
import com.example.marvel_clean_architecture.framework.datasource.remote.mapper.toDomain
import com.example.marvel_clean_architecture.framework.service.MarvelApi

class MarvelRemoteSourceImpl(private val marvelApi: MarvelApi) : IMarvelRemoteSource {

    override suspend fun getAll(): List<MarvelCharactersDomain> {
        return marvelApi.getMarvelCharacters().data.results.map {
            // Map the Result (Data from the API) to Domain (common data class)
            it.toDomain()
        }
    }
}