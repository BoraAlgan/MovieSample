package com.example.moviesample.data.remote.api

import com.example.moviesample.data.remote.model.PopularMovieResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {
    @GET("movie/popular/")
    suspend fun getLatestMovies(): Response<PopularMovieResponseModel>
}
/*
interface DetailApiClient{
    @GET("/movie/:movie_id/")
    suspend fun getDetailsMovies():
}
*/