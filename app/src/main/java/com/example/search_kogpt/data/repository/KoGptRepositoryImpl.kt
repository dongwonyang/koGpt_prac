package com.example.search_kogpt.data.repository

import com.example.search_kogpt.data.remote.KoGptRemoteDatasource
import com.example.search_kogpt.domain.model.KoGptEntity
import com.example.search_kogpt.domain.model.toEntity
import com.example.search_kogpt.domain.repository.KoGptRepository

class KoGptRepositoryImpl(
    private val remoteDatasource: KoGptRemoteDatasource
) : KoGptRepository {
    override suspend fun koGptGenerate(
        prompt: String,
        max_tokens: Int,
        temperature: Double,
        top_p: Double,
        n: Int
    ): KoGptEntity =
        remoteDatasource.koGptGenerate(
            prompt,
            max_tokens,
            temperature,
            top_p,
            n
        ).toEntity()
}