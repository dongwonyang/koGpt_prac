package com.example.search_kogpt.presentation.main.search

sealed interface SearchUiState {
    data class ErrorUiState(val e: Exception) : SearchUiState
    data class NormalUiState(val list: List<SearchListItem>) : SearchUiState

    companion object {
        fun init(): SearchUiState = NormalUiState(listOf(
            SearchListItem(SearchType.PROMPT, "dd"),
            SearchListItem(SearchType.ANSWER, "qq")
        ))
    }
}