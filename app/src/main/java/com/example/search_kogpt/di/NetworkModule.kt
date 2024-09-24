package com.example.search_kogpt.di

import com.example.search_kogpt.data.remote.KoGptRemoteDatasource
import com.example.search_kogpt.retrofit.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    private val baseUrl = "https://api.kakaobrain.com"

    @Provides
    fun provideAuthorizationInterceptor(): AuthorizationInterceptor = AuthorizationInterceptor()

    @Provides
    fun provideOkHttpClient(
        authorizationInterceptor: AuthorizationInterceptor
    ): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(authorizationInterceptor)
        .addInterceptor(HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        })
        .connectTimeout(300, TimeUnit.SECONDS) // 연결 타임아웃
        .readTimeout(300, TimeUnit.SECONDS)    // 읽기 타임아웃
        .writeTimeout(300, TimeUnit.SECONDS)   // 쓰기 타임아웃
        .build()


    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    fun provideKoGptRemoteDatasource(
        retrofit: Retrofit
    ): KoGptRemoteDatasource = retrofit.create(KoGptRemoteDatasource::class.java)
}