package com.example.moviesample.data

import com.example.moviesample.data.remote.datasource.MovieRemoteDataSource
import com.example.moviesample.data.remote.model.MovieDetailResponseModel
import com.example.moviesample.data.remote.model.MovieResponseModel
import com.example.moviesample.data.remote.model.PopularMovieResponseModel

import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val dataSource: MovieRemoteDataSource
) {


    suspend fun getAllPopularMoviesFromApi(): List<MovieResponseModel> {
        val response: PopularMovieResponseModel? = dataSource.getPopularMovies()
        return response?.results ?: emptyList()
    }


    suspend fun getAllPopularDetailsMoviesFromApi(id: Int): MovieDetailResponseModel? {
        return dataSource.getDetailsMovies(id)
    }


}