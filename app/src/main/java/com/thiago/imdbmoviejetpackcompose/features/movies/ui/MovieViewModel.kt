package com.thiago.imdbmoviejetpackcompose.features.movies.ui


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.imdbmoviejetpackcompose.common.ApiState
import com.thiago.imdbmoviejetpackcompose.common.doOnFailure
import com.thiago.imdbmoviejetpackcompose.common.doOnLoading
import com.thiago.imdbmoviejetpackcompose.common.doOnSuccess
import com.thiago.imdbmoviejetpackcompose.data.model.Movies
import com.thiago.imdbmoviejetpackcompose.features.movies.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: MovieUseCase
) : ViewModel() {

    private val _res: MutableState<MovieState> = mutableStateOf(MovieState())
    val res: State<MovieState> = _res

    init {
        viewModelScope.launch {

            useCase.getMovies()
                .doOnSuccess {
                    _res.value = MovieState(
                        data= it!!

                    )
                }.doOnFailure {
                    _res.value = MovieState(
                        error = it?.message!!
                    )
                }.doOnLoading {
                    _res.value = MovieState(
                        isLoading = true
                    )
                }.collect()

        }
    }
}

data class MovieState(
    val data: List<Movies.Results> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
