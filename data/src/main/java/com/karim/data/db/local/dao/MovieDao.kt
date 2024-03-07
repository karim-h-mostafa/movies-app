package com.karim.data.db.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karim.data.db.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieEntity: MovieEntity)

    @Query("SELECT * FROM movies WHERE id = :movieId")
    fun getMovie(movieId: Long): MovieEntity
}