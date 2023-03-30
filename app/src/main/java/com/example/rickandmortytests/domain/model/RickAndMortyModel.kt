package com.example.rickandmortytests.domain.model

import com.example.rickandmortytests.data.dto.Result

data class RickAndMortyModel(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Result.toDomain() = RickAndMortyModel(
    created = created,
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    status = status,
    type = type,
    url = url
)
