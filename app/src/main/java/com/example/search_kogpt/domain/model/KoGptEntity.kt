package com.example.search_kogpt.domain.model

import com.google.gson.annotations.SerializedName

data class KoGptEntity (
    val id: String,
    val generations: List<GenerationEntity>,
    val usage: UsageEntity
)

data class GenerationEntity(
    val text: String,
    val tokens: Int,
)

data class UsageEntity(
    val prompt_tokens: Int,
    val generated_tokens: Int,
    val total_tokens: Int
)