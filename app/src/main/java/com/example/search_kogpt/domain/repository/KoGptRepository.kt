package com.example.search_kogpt.domain.repository

import com.example.search_kogpt.data.response.KoGptResponse
import com.example.search_kogpt.domain.model.KoGptEntity
import retrofit2.http.POST
import retrofit2.http.Query

interface KoGptRepository {
    suspend fun koGptGenerate(
        prompt: String,
        max_tokens: Int,
        temperature: Double = 1.0, // 0~1 사이 창의력 정도
        top_p: Double = 1.0, // 0~1 사이 창의력 정도
        n: Int = 1 // 생성할 답변 개수, 1~16
    ): KoGptEntity
}