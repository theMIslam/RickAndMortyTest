package com.example.rickandmortytests.domain.repositories

import com.example.rickandmortytests.data.dtos.Characters

interface RickAndMortyRepository {
    suspend fun getCharacters(): Characters
}