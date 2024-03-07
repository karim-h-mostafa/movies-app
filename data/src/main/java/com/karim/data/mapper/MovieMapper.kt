package com.karim.data.mapper

import com.karim.data.db.remote.model.MovieItem
import com.karim.data.db.remote.model.MovieItemDetails
import com.karim.domain.model.Movie

interface MovieMapper {
    fun toMovie(movieItemDetails: MovieItemDetails):Movie
    fun toMovieItem(movieItem: MovieItem):com.karim.domain.model.MovieItem
}
