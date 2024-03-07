package com.karim.data.datasource

import com.karim.domain.model.Movie
import com.karim.domain.model.MovieItem

interface MoviesRemoteDataSource {
    suspend fun getMovies():Result<List<MovieItem>>
    suspend fun getMovieDetails(movieId:Long):Result<Movie>
}