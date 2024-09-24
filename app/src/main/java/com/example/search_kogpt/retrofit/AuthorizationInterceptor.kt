package com.example.search_kogpt.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val REST_API_KEY = ""
        val newRequest = chain.request().newBuilder()
            .addHeader(
                "Content-Type",
                "application/json")
            .addHeader(
                "Authorization",
                "KakaoAK ${REST_API_KEY}"
            ).build()

        return chain.proceed(newRequest)
    }
}