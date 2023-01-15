package com.example.marvel_clean_architecture.framework.datasource.remote.model

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)