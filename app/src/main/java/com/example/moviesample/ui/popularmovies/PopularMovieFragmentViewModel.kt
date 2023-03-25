package com.example.moviesample.ui.popularmovies


import androidx.lifecycle.*
import com.example.moviesample.data.MovieRepository
import com.example.moviesample.data.remote.model.MovieDetailResponseModel
import com.example.moviesample.data.remote.model.MovieResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PopularMovieFragmentViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    val liveData = MutableLiveData<List<MovieResponseModel>>()

    init {
        getPopularMovies()
    }

    fun getPopularMovies() {
        viewModelScope.launch {
            val movies: List<MovieResponseModel> = repository.getAllPopularMoviesFromApi()
            if (movies.isNotEmpty()) {

                liveData.value = movies

            }
        }
    }


}