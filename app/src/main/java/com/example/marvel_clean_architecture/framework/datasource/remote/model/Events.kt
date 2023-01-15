package com.example.marvel_clean_architecture.framework.datasource.remote.model

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)