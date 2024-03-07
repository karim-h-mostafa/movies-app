package com.karim.data.datasource

import com.karim.data.db.local.entity.MovieCategoryCrossRef
import com.karim.data.db.remote.model.Genre
import com.karim.data.db.remote.model.MovieItemDetails
import com.karim.domain.model.Category
import com.karim.domain.model.Movie
import com.karim.domain.model.MovieCategory
import kotlinx.coroutines.flow.Flow

interface MoviesLocalDateSource {
    suspend fun addMovie(movie: Movie)
    suspend fun addCategory(category: Category)
    suspend fun addMovieCategory(movieCategory: MovieCategory)
    suspend fun getMovieDetails(movieId: Long): Movie
    suspend fun getCategories():Flow<List<Category>>
    suspend fun getCategoryMovies(categoryId: Long): Flow<List<Movie>>
}