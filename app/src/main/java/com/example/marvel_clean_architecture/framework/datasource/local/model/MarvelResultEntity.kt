package com.example.marvel_clean_architecture.framework.datasource.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvel_clean_architecture.framework.datasource.local.model.MarvelResultEntity.Companion.TABLE_NAME
import com.example.marvel_clean_architecture.framework.datasource.remote.model.Thumbnail

@Entity(tableName = TABLE_NAME)
data class MarvelResultEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    @Embedded
    val thumbnail: Thumbnail,
) {
    internal companion object {
        const val TABLE_NAME = "marvel"
    }
}
