package com.karim.data.datasource

import com.karim.data.db.remote.api.MoviesAPI
import com.karim.data.mapper.MovieMapper
import com.karim.domain.model.Movie
import com.karim.domain.model.MovieItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRemoteDataSourceImpl(
    private val moviesAPI: MoviesAPI,
    private val movieMapper: MovieMapper
) : MoviesRemoteDataSource {
    override suspend fun getMovies(): Result<List<MovieItem>> = withContext(Dispatchers.IO) {
        try {
            val response = moviesAPI.getMoviesList()
            if (response.isSuccessful) {
                return@withContext Result.success(response.body()?.results?.map { dataMovieItem ->
                    movieMapper.toMovieItem(
                        dataMovieItem
                    )
                }!!)
            } else
                return@withContext Result.failure(Exception(response.message()))
        } catch (e: Exception) {
            return@withContext Result.failure(e)
        }
    }

    override suspend fun getMovieDetails(movieId: Long): Result<Movie> =
        withContext(Dispatchers.IO) {
            try {
                val response = moviesAPI.getMovieDetails(movieId)
                if (response.isSuccessful) {
                    return@withContext Result.success(movieMapper.toMovie(response.body()!!))
                } else
                    return@withContext Result.failure(Exception(response.message()))
            } catch (e: Exception) {
                return@withContext Result.failure(e)
            }
        }
}