package com.karim.domain.model

data class Movie(
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
) {
}