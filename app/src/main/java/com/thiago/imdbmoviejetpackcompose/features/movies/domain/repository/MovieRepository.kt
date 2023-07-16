package com.thiago.imdbmoviejetpackcompose.features.movies.domain.repository



import com.thiago.imdbmoviejetpackcompose.common.ApiState
import com.thiago.imdbmoviejetpackcompose.data.model.Movies
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface  MovieRepository {
    suspend fun getMovies(): Flow<ApiState<Movies>>
}