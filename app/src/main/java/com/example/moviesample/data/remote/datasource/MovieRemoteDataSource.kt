package com.example.moviesample.data.remote.datasource

import com.example.moviesample.data.remote.api.MovieApiClient
import com.example.moviesample.data.remote.model.MovieDetailResponseModel
import com.example.moviesample.data.remote.model.PopularMovieResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val api: MovieApiClient) {

    suspend fun getPopularMovies(): PopularMovieResponseModel? {
        return withContext(Dispatchers.IO) {
            val responsePopularMovies = api.getLatestMovies()
            responsePopularMovies.body()
        }
    }

    suspend fun getDetailsMovies(id: Int): MovieDetailResponseModel? {
        return withContext(Dispatchers.IO) {
            val responseDetailsMovies = api.getDetailsMovies(id)
            responseDetailsMovies.body()
        }
    }

}