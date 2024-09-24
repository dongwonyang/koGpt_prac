package com.example.search_kogpt.presentation.main.search

import androidx.lifecycle.ViewModel
import com.example.search_kogpt.domain.repository.KoGptRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class SearchViewModel(
    private val koGptRepositroy: KoGptRepository
):ViewModel() {
    private val _uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.init())
    val uiState = _uiState.asStateFlow()
}