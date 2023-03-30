package com.example.rickandmortytests.di

import com.example.rickandmortytests.data.api.ApiService
import com.example.rickandmortytests.data.repository.RickAndMortyRepositoryImpl
import com.example.rickandmortytests.domain.repository.RickAndMortyRepository
import com.example.rickandmortytests.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
object ModuleApp {

    @Singleton
    @Provides
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService): RickAndMortyRepository = RickAndMortyRepositoryImpl(apiService)
}