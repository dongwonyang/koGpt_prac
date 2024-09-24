package com.example.search_kogpt.presentation.main.search

data class SearchListItem (
    val type: SearchType,
    val text: String
)

enum class SearchType{
    PROMPT, ANSWER
}