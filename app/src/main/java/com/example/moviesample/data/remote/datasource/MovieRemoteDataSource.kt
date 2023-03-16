package com.example.moviesample.data.remote.datasource

import com.example.moviesample.data.remote.api.MovieApiClient
import com.example.moviesample.data.remote.model.PopularMovieResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val api:MovieApiClient){

    suspend fun getPopularMovies(): PopularMovieResponseModel? {
        return withContext(Dispatchers.IO) {
            val response = api.getLatestMovies()
            response.body()
        }
    }
}