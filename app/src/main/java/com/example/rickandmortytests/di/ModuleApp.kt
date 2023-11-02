package com.example.rickandmortytests.di

import com.example.rickandmortytests.data.apiservice.ApiService
import com.example.rickandmortytests.data.repositories.RickAndMortyRepositoryImpl
import com.example.rickandmortytests.domain.repositories.RickAndMortyRepository
import com.example.rickandmortytests.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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