package com.example.rickandmortytests.domain.repository

import com.example.rickandmortytests.data.dto.Characters

interface RickAndMortyRepository {
    suspend fun getCharacters(): Characters
}