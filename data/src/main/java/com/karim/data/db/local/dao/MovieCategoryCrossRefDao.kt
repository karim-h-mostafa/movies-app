package com.karim.data.db.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karim.data.db.local.entity.CategoryEntity
import com.karim.data.db.local.entity.MovieEntity
import com.karim.data.db.local.entity.MovieCategoryCrossRef
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieCategoryCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(crossRef: MovieCategoryCrossRef)

    @Query("SELECT * FROM movie_category_cross_ref WHERE movieId = :movieId")
    fun getCategoriesForMovie(movieId: Long): List<CategoryEntity>

    @Query("SELECT * FROM movie_category_cross_ref WHERE categoryId = :categoryId")
    fun getMoviesForCategory(categoryId: Long): Flow<List<MovieEntity>>
}