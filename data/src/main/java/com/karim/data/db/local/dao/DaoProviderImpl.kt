package com.karim.data.db.local.dao

import com.karim.data.db.local.MoviesDatabase

class DaoProviderImpl(private val moviesDatabase: MoviesDatabase):DaoProvider {
    override fun movieDao(): MovieDao {
        return moviesDatabase.moviesDao()
    }

    override fun categoryDao(): CategoryDao {
        return moviesDatabase.categoriesDao()
    }

    override fun movieCategoryDao(): MovieCategoryCrossRefDao {
        return moviesDatabase.moviesCategoriesDao()
    }
}