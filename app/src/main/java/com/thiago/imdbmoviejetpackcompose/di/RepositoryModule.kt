package com.thiago.imdbmoviejetpackcompose.di


import com.thiago.imdbmoviejetpackcompose.data.repository.MovieRepositoryImp
import com.thiago.imdbmoviejetpackcompose.features.movies.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesMovieRepository(
       repo: MovieRepositoryImp
    ): MovieRepository


}