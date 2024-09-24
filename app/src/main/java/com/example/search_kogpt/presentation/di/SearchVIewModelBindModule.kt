package com.example.search_kogpt.presentation.di

import com.example.search_kogpt.data.repository.KoGptRepositoryImpl
import com.example.search_kogpt.domain.repository.KoGptRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class SearchVIewModelBindModule {

    @Binds
    abstract fun bindKoGptRepository(
      repository: KoGptRepositoryImpl
    ):KoGptRepository
}