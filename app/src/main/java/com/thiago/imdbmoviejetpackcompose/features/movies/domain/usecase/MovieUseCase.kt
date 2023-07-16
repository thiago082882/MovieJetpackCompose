package com.thiago.imdbmoviejetpackcompose.features.movies.domain.usecase



import com.thiago.imdbmoviejetpackcompose.common.ApiState
import com.thiago.imdbmoviejetpackcompose.common.map
import com.thiago.imdbmoviejetpackcompose.data.model.Movies
import com.thiago.imdbmoviejetpackcompose.features.movies.domain.mapper.MovieMapper
import com.thiago.imdbmoviejetpackcompose.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val repo: MovieRepository,
    private val mapper:MovieMapper
) {

    suspend fun getMovies():Flow<ApiState<List<Movies.Results>?>> {
        return repo.getMovies().map { results->
            results.map {
                mapper.fromMap(it)



            }
        }
    }
}