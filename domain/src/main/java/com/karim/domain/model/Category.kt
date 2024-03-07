package com.karim.domain.model

data class Category(
    val id: Long,
    val name: String,
    val movie: List<Movie>
) {

}
