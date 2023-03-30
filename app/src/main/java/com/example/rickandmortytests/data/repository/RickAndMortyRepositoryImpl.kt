package com.example.rickandmortytests.data.repository

import com.example.rickandmortytests.data.api.ApiService
import com.example.rickandmortytests.data.dto.Characters
import com.example.rickandmortytests.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(private val apiService: ApiService): RickAndMortyRepository{
    override suspend fun getCharacters(): Characters = apiService.getCharacters()
}