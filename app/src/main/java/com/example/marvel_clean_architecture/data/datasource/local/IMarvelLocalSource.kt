package com.example.marvel_clean_architecture.data.datasource.local

import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain

interface IMarvelLocalSource {

    suspend fun saveMarvelCharacters(marvelCharacters: List<MarvelCharactersDomain>)

    suspend fun getMarvelCharacters(): List<MarvelCharactersDomain>

}