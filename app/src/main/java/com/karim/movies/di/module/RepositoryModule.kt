package com.karim.movies.di.module

import com.karim.data.datasource.MoviesLocalDateSource
import com.karim.data.datasource.MoviesLocalDateSourceImpl
import com.karim.data.datasource.MoviesRemoteDataSource
import com.karim.data.datasource.MoviesRemoteDataSourceImpl
import com.karim.data.db.local.MoviesDatabase
import com.karim.data.db.local.dao.DaoProvider
import com.karim.data.db.remote.api.MoviesAPI
import com.karim.data.mapper.CategoryEntityMapper
import com.karim.data.mapper.MovieCategoryEntityMapper
import com.karim.data.mapper.MovieEntityMapper
import com.karim.data.mapper.MovieMapper
import com.karim.data.repository.MoviesRepositoryImpl
import com.karim.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun moviesRepository(
        moviesLocalDateSource: MoviesLocalDateSource,
        moviesRemoteDataSource: MoviesRemoteDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(moviesLocalDateSource, moviesRemoteDataSource)
    }

    @Provides
    fun moviesRemoteDataSource(
        movieMapper: MovieMapper,
        moviesAPI: MoviesAPI
    ): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImpl(
            moviesAPI,
            movieMapper
        )
    }

    @Provides
    fun moviesLocalDateSource(
        moviesDatabase: MoviesDatabase,
        movieEntityMapper: MovieEntityMapper,
        categoryEntityMapper: CategoryEntityMapper,
        movieCategoryEntityMapper: MovieCategoryEntityMapper,
        coroutineDispatcher: CoroutineDispatcher,
        daoProvider: DaoProvider
    ): MoviesLocalDateSource {
        return MoviesLocalDateSourceImpl(
            movieEntityMapper,
            categoryEntityMapper,
            movieCategoryEntityMapper,
            coroutineDispatcher,
            daoProvider
        )
    }
}