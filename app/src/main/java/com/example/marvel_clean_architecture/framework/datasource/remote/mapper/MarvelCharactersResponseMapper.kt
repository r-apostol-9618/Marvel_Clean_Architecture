package com.example.marvel_clean_architecture.framework.datasource.remote.mapper

import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain
import com.example.marvel_clean_architecture.framework.datasource.remote.model.Result

/**
 * Mapping between the Result from the API call and the Domain (common data class)
 * */
fun Result.toDomain(): MarvelCharactersDomain {
    return MarvelCharactersDomain(
        id = id,
        name = name,
        description = description,
        thumbnail = thumbnail
    )
}
