package com.karim.domain.repository

import com.karim.domain.model.Category
import com.karim.domain.model.Movie
import com.karim.domain.model.MovieCategory
import com.karim.domain.model.MovieItem
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getRemoteMovies(): Result<List<MovieItem>>
    suspend fun getRemoteMovieDetails(movieId: Long):Result<Movie>
    suspend fun addMovie(movie: Movie)
    suspend fun addCategory(category: Category)
    suspend fun addMovieCategory(movieCategory: MovieCategory)
    suspend fun getCategoryMovies(): Flow<List<Category>>
    suspend fun getMovieDetails(movieId: Long):Movie

}