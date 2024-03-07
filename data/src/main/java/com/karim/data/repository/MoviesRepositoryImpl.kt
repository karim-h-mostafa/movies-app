package com.karim.data.repository

import com.karim.data.datasource.MoviesLocalDateSource
import com.karim.data.datasource.MoviesRemoteDataSource
import com.karim.domain.model.Category
import com.karim.domain.model.Movie
import com.karim.domain.model.MovieCategory
import com.karim.domain.model.MovieItem
import com.karim.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class MoviesRepositoryImpl(
    private val localDateSource: MoviesLocalDateSource,
    private val remoteDataSource: MoviesRemoteDataSource
):MoviesRepository {
    override suspend fun getRemoteMovies(): Result<List<MovieItem>> {
        return remoteDataSource.getMovies()
    }

    override suspend fun getRemoteMovieDetails(movieId: Long): Result<Movie> {
        return remoteDataSource.getMovieDetails(movieId)
    }

    override suspend fun addMovie(movie: Movie) {
        return localDateSource.addMovie(movie)
    }

    override suspend fun addCategory(category: Category) {
        return localDateSource.addCategory(category)
    }

    override suspend fun addMovieCategory(movieCategory: MovieCategory) {
        return localDateSource.addMovieCategory(movieCategory)
    }

    override suspend fun getCategoryMovies(): Flow<List<Category>> {
        return localDateSource.getCategories()
    }

    override suspend fun getMovieDetails(movieId: Long): Movie {
        return localDateSource.getMovieDetails(movieId)
    }
}