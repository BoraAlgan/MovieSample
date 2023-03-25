package com.example.moviesample.data.remote.model

import com.google.gson.annotations.SerializedName

data class PopularMovieResponseModel(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("results")
    val results: List<MovieResponseModel>?,
    @SerializedName("total_results")
    val totalResults: Int = 0
)