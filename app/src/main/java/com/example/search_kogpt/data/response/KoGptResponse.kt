package com.example.search_kogpt.data.response

import com.google.gson.annotations.SerializedName

data class KoGptResponse (
    @SerializedName("id") val id: String?,
    @SerializedName("generations") val generations: List<GenerationResponse>?,
    @SerializedName("usage") val usage: UsageResponse?
)

data class GenerationResponse(
    @SerializedName("text") val text: String?,
    @SerializedName("tokens") val tokens: Int?,
)

data class UsageResponse(
    @SerializedName("prompt_tokens") val prompt_tokens: Int?,
    @SerializedName("generated_tokens") val generated_tokens: Int?,
    @SerializedName("total_tokens") val total_tokens: Int?
)