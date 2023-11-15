package com.example.rickandmortytests.data.apiservice

import com.example.rickandmortytests.data.dtos.Characters
import com.example.rickandmortytests.util.Constants
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET(Constants.END_POINT)
    suspend fun getCharacters(): Characters
}