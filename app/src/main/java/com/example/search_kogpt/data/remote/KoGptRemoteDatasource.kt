package com.example.search_kogpt.data.remote

import com.example.search_kogpt.data.response.KoGptResponse
import retrofit2.http.POST
import retrofit2.http.Query


interface KoGptRemoteDatasource {
    @POST("v1/inference/kogpt/generation")
    suspend fun koGptGenerate(
        @Query("prompt") prompt: String,
        @Query("max_tokens") max_tokens: Int,
        @Query("temperature") temperature: Double,
        @Query("top_p") top_p: Double,
        @Query("n") n: Int = 1
    ):KoGptResponse
}