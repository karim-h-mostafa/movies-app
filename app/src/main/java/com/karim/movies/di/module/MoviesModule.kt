package com.karim.movies.di.module

import android.content.Context
import com.karim.data.db.local.MoviesDatabase
import com.karim.data.db.local.dao.DaoProvider
import com.karim.data.db.local.dao.DaoProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {
    @Singleton
    @Provides
    fun moviesDatabase(@ApplicationContext context: Context): MoviesDatabase {
        return MoviesDatabase.buildDatabase(context)
    }

    @Singleton
    @Provides
    fun daoProvider(moviesDatabase: MoviesDatabase): DaoProvider {
        return DaoProviderImpl(moviesDatabase)
    }

    @Singleton
    @Provides
    fun coroutineDispatcher(): CoroutineDispatcher{
        return Dispatchers.IO
    }
}