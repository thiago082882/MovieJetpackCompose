package com.thiago.imdbmoviejetpackcompose.data.network

import com.thiago.imdbmoviejetpackcompose.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    @GET("discover/movie?api_key=c9856d0cb57c3f14bf75bdc6c063b8f3")
    suspend fun getMovies(): Response<Movies>
}