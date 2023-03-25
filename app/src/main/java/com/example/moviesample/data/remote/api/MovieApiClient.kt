package com.example.moviesample.data.remote.api

import com.example.moviesample.data.remote.model.MovieDetailResponseModel
import com.example.moviesample.data.remote.model.PopularMovieResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiClient {
    @GET("movie/popular/")
    suspend fun getLatestMovies(): Response<PopularMovieResponseModel>

    @GET("movie/{id}")
    suspend fun getDetailsMovies(
        @Path("id") id: Int
    ): Response<MovieDetailResponseModel>
}


