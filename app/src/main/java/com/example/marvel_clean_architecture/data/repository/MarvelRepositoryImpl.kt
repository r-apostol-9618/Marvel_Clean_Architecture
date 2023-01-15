package com.example.marvel_clean_architecture.data.repository

import com.example.marvel_clean_architecture.data.datasource.local.IMarvelLocalSource
import com.example.marvel_clean_architecture.data.datasource.remote.IMarvelRemoteSource
import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain
import com.example.marvel_clean_architecture.domain.repository.IMarvelRepository

class MarvelRepositoryImpl(
    private val marvelRemoteSource: IMarvelRemoteSource,
    private val marvelLocalSource: IMarvelLocalSource
) : IMarvelRepository {

    /**
     * Get the data from the API and save in a local variable
     * Save the data from the API in the CACHE/DB
     * Return the data from the API
     */
    override suspend fun fetchMarvelCharacters(): List<MarvelCharactersDomain> {
        val marvelCharacters = marvelRemoteSource.getAll()
        marvelLocalSource.saveMarvelCharacters(marvelCharacters)
        return marvelCharacters
    }

    /**
     * Get the data from the CACHE/DB and return it
     */
    override suspend fun fetchMarvelCharactersFromCache(): List<MarvelCharactersDomain> {
        return marvelLocalSource.getMarvelCharacters()
    }

}