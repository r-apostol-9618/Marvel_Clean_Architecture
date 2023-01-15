package com.example.marvel_clean_architecture.framework.datasource.local.mapper

import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain
import com.example.marvel_clean_architecture.framework.datasource.local.model.MarvelResultEntity

/**
 * Mapping between the Entity from the ROOM DB and the Domain (common data class)
 */
fun MarvelResultEntity.toDomain(): MarvelCharactersDomain {
    return MarvelCharactersDomain(
        id = id,
        name = name,
        description = description,
        thumbnail = thumbnail
    )
}

/***
 * Mapping between Domain (common data class) and the Entity from the ROOM DB
 */
fun MarvelCharactersDomain.toEntity(): MarvelResultEntity {
    return MarvelResultEntity(
        id = id,
        name = name,
        description = description,
        thumbnail = thumbnail
    )
}
