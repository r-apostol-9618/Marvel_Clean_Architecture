package com.example.marvel_clean_architecture.framework.service

import com.example.marvel_clean_architecture.framework.Constants
import com.example.marvel_clean_architecture.framework.datasource.remote.model.MarvelCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    suspend fun getMarvelCharacters(
        @Query("ts") ts: String = Constants.ts,
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("hash") hash: String = Constants.generateMd5Hash(),
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 1240
    ): MarvelCharactersResponse


}
