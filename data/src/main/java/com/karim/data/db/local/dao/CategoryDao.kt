package com.karim.data.db.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karim.data.db.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categoryEntity: CategoryEntity)

    @Query("SELECT * FROM categories")
    fun getAllCategories(): Flow <List<CategoryEntity>>
    // Other category queries
}