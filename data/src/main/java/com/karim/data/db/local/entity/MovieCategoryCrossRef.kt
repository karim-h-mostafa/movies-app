package com.karim.data.db.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "movie_category_cross_ref",
    primaryKeys = ["movieId", "categoryId"],
    foreignKeys = [
        ForeignKey(entity = MovieEntity::class, parentColumns = ["id"], childColumns = ["movieId"]),
        ForeignKey(entity = CategoryEntity::class, parentColumns = ["id"], childColumns = ["categoryId"])
    ]
)
data class MovieCategoryCrossRef(
    val movieId: Long,
    val categoryId: Long
)