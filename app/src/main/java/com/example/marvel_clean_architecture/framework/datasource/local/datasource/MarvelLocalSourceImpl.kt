package com.example.marvel_clean_architecture.framework.datasource.local.datasource

import com.example.marvel_clean_architecture.data.datasource.local.IMarvelLocalSource
import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain
import com.example.marvel_clean_architecture.framework.database.dao.IMarvelDao
import com.example.marvel_clean_architecture.framework.datasource.local.mapper.toDomain
import com.example.marvel_clean_architecture.framework.datasource.local.mapper.toEntity

class MarvelLocalSourceImpl(private val marvelDao: IMarvelDao) : IMarvelLocalSource {

    override suspend fun saveMarvelCharacters(marvelCharacters: List<MarvelCharactersDomain>) {
        marvelDao.insert(*marvelCharacters.map {
            // Map the Domain (common data class) and the Entity from the ROOM DB
            it.toEntity()
        }.toTypedArray())
    }

    override suspend fun getMarvelCharacters(): List<MarvelCharactersDomain> {
        return marvelDao.getAll().map { it.toDomain() }
    }

}