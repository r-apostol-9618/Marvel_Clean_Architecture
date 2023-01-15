package com.example.marvel_clean_architecture.domain.model

import com.example.marvel_clean_architecture.framework.datasource.remote.model.Thumbnail

data class MarvelCharactersDomain (
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail : Thumbnail,
)