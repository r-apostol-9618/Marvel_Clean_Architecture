package com.example.marvel_clean_architecture.domain.usecase

import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain
import com.example.marvel_clean_architecture.domain.repository.IMarvelRepository

interface IFetchAndObserveMarvelUseCase {
    /**
     * Fetch Marvel Characters from REMOTE and save a copy in local DATABASE
     */
    suspend operator fun invoke(): List<MarvelCharactersDomain>
}

class FetchAndObserveMarvelUseCaseImpl(private val marvelRepository: IMarvelRepository) :
    IFetchAndObserveMarvelUseCase {

    override suspend operator fun invoke(): List<MarvelCharactersDomain> {
        return marvelRepository.fetchMarvelCharacters()
    }

}