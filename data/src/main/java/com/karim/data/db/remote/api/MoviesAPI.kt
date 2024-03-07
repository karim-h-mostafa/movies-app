package com.karim.data.db.remote.api

import com.karim.data.db.remote.model.MovieItemDetails
import com.karim.data.db.remote.model.MoviesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesAPI {
    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") movieId:Long):Response<MovieItemDetails>
    @GET("movie/changes")
    suspend fun getMoviesList(): Response<MoviesListResponse>
}