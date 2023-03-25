package com.example.moviesample.ui.popularmovies.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesample.data.MovieRepository
import com.example.moviesample.data.remote.model.MovieDetailResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMovieDetailFragmentViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    val liveDataDetails = MutableLiveData<MovieDetailResponseModel?>()


    fun getDetailsMovies(id: Int) {
        viewModelScope.launch {
            val moviesDetails: MovieDetailResponseModel? =
                repository.getAllPopularDetailsMoviesFromApi(id)
            moviesDetails.apply {
                liveDataDetails.value = moviesDetails
            }

        }
    }
}