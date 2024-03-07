package com.karim.data.datasource

import com.karim.data.mapper.MovieEntityMapper
import com.karim.data.db.local.dao.CategoryDao
import com.karim.data.db.local.dao.DaoProvider
import com.karim.data.db.local.dao.MovieCategoryCrossRefDao
import com.karim.data.db.local.dao.MovieDao
import com.karim.data.db.local.entity.MovieCategoryCrossRef
import com.karim.data.mapper.CategoryEntityMapper
import com.karim.data.db.remote.model.Genre
import com.karim.data.db.remote.model.MovieItemDetails
import com.karim.data.mapper.MovieCategoryEntityMapper
import com.karim.domain.model.Category
import com.karim.domain.model.Movie
import com.karim.domain.model.MovieCategory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class MoviesLocalDateSourceImpl(
    private val movieEntityMapper: MovieEntityMapper,
    private val categoryEntityMapper: CategoryEntityMapper,
    private val movieCategoryEntityMapper: MovieCategoryEntityMapper,
    private val dispatcher: CoroutineDispatcher,
    private val daoProvider: DaoProvider
) : MoviesLocalDateSource {
    override suspend fun addMovie(movie: Movie) =
        withContext(dispatcher) {
            daoProvider.movieDao().insert(movieEntityMapper.toMovieEntity(movie))
        }

    override suspend fun addCategory(category: Category) =
        withContext(dispatcher) {
            daoProvider.categoryDao().insert(categoryEntityMapper.toCategoryEntity(category))
        }

    override suspend fun addMovieCategory(movieCategory: MovieCategory) =
        withContext(dispatcher) {
            daoProvider.movieCategoryDao().insert(movieCategoryEntityMapper.toMovieCategoryEntity(movieCategory))
        }


    override suspend fun getMovieDetails(movieId: Long): Movie = withContext(dispatcher) {
        movieEntityMapper.toMovie(daoProvider.movieDao().getMovie(movieId))
    }

    override suspend fun getCategories(): Flow<List<Category>> {
        return daoProvider.categoryDao().getAllCategories().map { categoryEntityList ->
            categoryEntityList.map { categoryEntity ->
                categoryEntityMapper.toCategory(categoryEntity)
            }
        }
    }

    override suspend fun getCategoryMovies(categoryId: Long): Flow<List<Movie>> {
        return daoProvider.movieCategoryDao().getMoviesForCategory(categoryId)
            .map { movieEntityList ->
                movieEntityList.map { movieEntity ->
                    movieEntityMapper.toMovie(
                        movieEntity
                    )
                }
            }

    }


}