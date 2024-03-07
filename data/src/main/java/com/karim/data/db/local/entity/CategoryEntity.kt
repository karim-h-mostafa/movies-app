package com.karim.data.db.local.entity

import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    /*@Relation(
        entity = MovieEntity::class,
        parentColumn = "categoryId",
        entityColumn = "movieId",
        associateBy = Junction(MovieCategoryCrossRef::class)
    )
    val movies: List<MovieEntity> = emptyList()*/
)