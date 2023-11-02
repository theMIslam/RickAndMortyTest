package com.example.rickandmortytests.domain.usecases

import com.example.rickandmortytests.domain.model.RickAndMortyModel
import com.example.rickandmortytests.domain.model.toDomain
import com.example.rickandmortytests.domain.repositories.RickAndMortyRepository
import com.example.rickandmortytests.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RickAndMortyUseCase @Inject constructor(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(): Flow<Resource<List<RickAndMortyModel>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getCharacters().results.map { it.toDomain() }
            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "no internet connection"))
        } catch (e: IOException) {
            emit(Resource.Error("Error"))
        }
    }
}