package com.karim.data.db.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.karim.data.db.local.dao.CategoryDao
import com.karim.data.db.local.dao.MovieCategoryCrossRefDao
import com.karim.data.db.local.dao.MovieDao
import com.karim.data.db.local.entity.CategoryEntity
import com.karim.data.db.local.entity.MovieCategoryCrossRef
import com.karim.data.db.local.entity.MovieEntity

@Database(
    entities = [
        MovieEntity::class,
        CategoryEntity::class,
        MovieCategoryCrossRef::class
    ], version = 1
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MovieDao
    abstract fun categoriesDao(): CategoryDao
    abstract fun moviesCategoriesDao(): MovieCategoryCrossRefDao
    companion object {
        fun buildDatabase(context: Context): MoviesDatabase {
            return Room.databaseBuilder(context, MoviesDatabase::class.java, "movies-database")
                .build()
        }
    }

}