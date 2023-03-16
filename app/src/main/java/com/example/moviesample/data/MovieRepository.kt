package com.example.moviesample.data

import androidx.lifecycle.MutableLiveData
import com.example.moviesample.data.remote.datasource.MovieRemoteDataSource
import com.example.moviesample.data.remote.model.MovieResponseModel
import com.example.moviesample.data.remote.model.PopularMovieResponseModel

import javax.inject.Inject


class MovieRepository  @Inject constructor(
    private val dataSource: MovieRemoteDataSource
) {


    suspend fun getAllPopularMoviesFromApi(): List<MovieResponseModel> {
        val response: PopularMovieResponseModel? = dataSource.getPopularMovies()
        return response?.results?: emptyList()
    }

}