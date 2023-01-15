package com.example.marvel_clean_architecture.framework.datasource.remote.model

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)