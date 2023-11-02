package com.example.rickandmortytests.data.repositories

import com.example.rickandmortytests.data.apiservice.ApiService
import com.example.rickandmortytests.data.dtos.Characters
import com.example.rickandmortytests.domain.repositories.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(private val apiService: ApiService): RickAndMortyRepository{
    override suspend fun getCharacters(): Characters = apiService.getCharacters()
}