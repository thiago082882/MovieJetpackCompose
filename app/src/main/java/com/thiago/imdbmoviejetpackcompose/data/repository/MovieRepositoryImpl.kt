package com.thiago.imdbmoviejetpackcompose.data.repository

import com.thiago.imdbmoviejetpackcompose.common.ApiState
import com.thiago.imdbmoviejetpackcompose.common.base.BaseRepository
import com.thiago.imdbmoviejetpackcompose.data.model.Movies
import com.thiago.imdbmoviejetpackcompose.data.network.ApiService
import com.thiago.imdbmoviejetpackcompose.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MovieRepositoryImp @Inject constructor(
    private val apiService: ApiService,
) :  MovieRepository,BaseRepository() {
    override suspend fun getMovies(): Flow<ApiState<Movies>> = safeApiCall {

        apiService.getMovies()
    }


}