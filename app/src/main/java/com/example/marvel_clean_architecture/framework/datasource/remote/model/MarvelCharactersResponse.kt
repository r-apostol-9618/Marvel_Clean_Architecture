package com.example.marvel_clean_architecture.framework.datasource.remote.model

data class MarvelCharactersResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)