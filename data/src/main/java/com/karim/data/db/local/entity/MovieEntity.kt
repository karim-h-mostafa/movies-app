package com.karim.data.db.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Long,
    val adult: Boolean,
    val posterPath:String,
    val backdropPath:String,
    val title:String,
    val overview:String,
    val tagline:String,
    val releaseDate:String,
    val releaseStatus:String,
    val imdb:String,
    val duration:String,
)