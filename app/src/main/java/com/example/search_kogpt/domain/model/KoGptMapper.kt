package com.example.search_kogpt.domain.model

import com.example.search_kogpt.data.response.GenerationResponse
import com.example.search_kogpt.data.response.KoGptResponse
import com.example.search_kogpt.data.response.UsageResponse

fun KoGptResponse.toEntity(): KoGptEntity = KoGptEntity(
    id = id ?: "",
    generations = generations?.map { response ->
        response?.toEntity() ?: GenerationEntity("", 0)
    } ?: emptyList(),
    usage = usage?.toEntity() ?: UsageEntity(0, 0, 0)
)

fun GenerationResponse.toEntity() = GenerationEntity(
    text = text ?: "",
    tokens = tokens ?: 0
)


fun UsageResponse.toEntity() = UsageEntity(
    prompt_tokens = prompt_tokens ?: 0,
    generated_tokens = generated_tokens ?: 0,
    total_tokens = total_tokens ?: 0
)



