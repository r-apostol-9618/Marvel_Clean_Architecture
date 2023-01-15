package com.example.marvel_clean_architecture.domain.usecase

import com.example.marvel_clean_architecture.domain.repository.IMarvelRepository
import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain

interface IFetchAndObserveMarvelFromCacheUseCase {
    /**
     * Get the data from the Local Database / Cache
     */
    suspend operator fun invoke(): List<MarvelCharactersDomain>
}

class FetchAndObserveMarvelUseCaseFromCacheImpl(private val marvelRepository: IMarvelRepository) :
    IFetchAndObserveMarvelFromCacheUseCase {

    override suspend fun invoke(): List<MarvelCharactersDomain> {
        return marvelRepository.fetchMarvelCharactersFromCache()
    }

}