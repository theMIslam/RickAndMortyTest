package com.example.rickandmortytests.data.api

import com.example.rickandmortytests.data.dto.Characters
import com.example.rickandmortytests.util.Constants
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getCharacters(): Characters
}