package com.example.marvel_clean_architecture.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_clean_architecture.domain.model.MarvelCharactersDomain
import com.example.marvel_clean_architecture.domain.usecase.IFetchAndObserveMarvelFromCacheUseCase
import com.example.marvel_clean_architecture.domain.usecase.IFetchAndObserveMarvelUseCase
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext


class MarvelViewModel : ViewModel() {

    private val fetchAndObserveMarvelUseCase: IFetchAndObserveMarvelUseCase by GlobalContext.get()
        .inject()

    private val fetchAndObserveMarvelUseCaseFromCacheUseCase: IFetchAndObserveMarvelFromCacheUseCase by GlobalContext.get()
        .inject()

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading = _dataLoading

    private val _errorCase = MutableLiveData<Boolean>()
    val errorCase = _errorCase

    private val _marvelCharactersList = MutableLiveData<List<MarvelCharactersDomain>>()
    val marvelCharactersList = _marvelCharactersList

    fun launchApi() {
        _dataLoading.postValue(true)
        viewModelScope.launch {
            try {
                // Load data from Remote
                val marvelCharactersList = fetchAndObserveMarvelUseCase()
                _marvelCharactersList.postValue(marvelCharactersList)
                _dataLoading.postValue(false)
                _errorCase.postValue(false)
            } catch (e: Exception) {
                // We try to get the data saved locally
                // If we have no data, we display a generic error message
                val marvelCharactersList = fetchAndObserveMarvelUseCaseFromCacheUseCase()

                if (marvelCharactersList.isNotEmpty()) {
                    _marvelCharactersList.postValue(marvelCharactersList)
                    _errorCase.postValue(false)
                } else {
                    _errorCase.postValue(true)
                }
                _dataLoading.postValue(false)

            }
        }
    }
}