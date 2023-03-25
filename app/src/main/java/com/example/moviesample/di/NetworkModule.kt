package com.example.moviesample.di

import com.example.moviesample.data.remote.api.MovieApiClient
import com.example.moviesample.util.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .callFactory { client.newCall(it) }
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApiClient(retrofit: Retrofit): MovieApiClient {
        return retrofit.create(MovieApiClient::class.java)
    }

    @Singleton
    @Provides
    fun providehttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .addInterceptor(ApiKeyInterceptor())
        return builder.build()
    }

}