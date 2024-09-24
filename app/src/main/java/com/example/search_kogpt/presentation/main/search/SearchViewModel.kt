package com.example.search_kogpt.presentation.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.search_kogpt.domain.repository.KoGptRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val koGptRepository: KoGptRepository
):ViewModel() {
    private val _uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.init())
    val uiState = _uiState.asStateFlow()

    fun generateKoGpt(prompt: String) = viewModelScope.launch{
        runCatching {
            val list = koGptRepository.koGptGenerate(prompt, 300).generations.map{
                SearchListItem(SearchType.ANSWER, it.text)
            }

            if(uiState.value is SearchUiState.NormalUiState) {
                _uiState.update { prev ->
                    (prev as SearchUiState.NormalUiState)
                    prev.copy(
                        list = prev.list + list
                    )
                }
            }
        }.onFailure { throwable ->
            val exception = throwable as? Exception ?: Exception("Unknown error") // 기본 예외로 대체
            _uiState.update {
                SearchUiState.ErrorUiState(exception)
            }
        }

    }


}