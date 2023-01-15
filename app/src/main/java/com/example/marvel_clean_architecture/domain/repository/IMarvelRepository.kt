package com.example.marvel_clean_architecture.domain.repository

import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain

interface IMarvelRepository {

    /**
     * Fetch Marvel Characters from REMOTE and save a copy in local DATABASE
     * */
    suspend fun fetchMarvelCharacters(): List<MarvelCharactersDomain>

    /**
     * Fetch Marvel Characters from LOCAL/CACHE
     * */
    suspend fun fetchMarvelCharactersFromCache(): List<MarvelCharactersDomain>

}