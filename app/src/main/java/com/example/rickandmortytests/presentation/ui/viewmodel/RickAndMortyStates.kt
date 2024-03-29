package com.example.rickandmortytests.presentation.ui.viewmodel

import com.example.rickandmortytests.domain.model.RickAndMortyModel

data class RickAndMortyStates (
    val load: Boolean = false,
    val success: List<RickAndMortyModel> = emptyList(),
    val fail: String = ""
)