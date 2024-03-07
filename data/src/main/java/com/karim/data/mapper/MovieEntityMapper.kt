package com.karim.data.mapper

import com.karim.data.db.local.entity.MovieEntity
import com.karim.data.db.remote.model.MovieItemDetails
import com.karim.domain.model.Movie

interface MovieEntityMapper {
    fun toMovieEntity(movieItemDetails: Movie): MovieEntity
    fun toMovie(movieEntity: MovieEntity):Movie
}