package com.karim.data.mapper

import com.karim.data.db.remote.model.MovieItem
import com.karim.data.db.remote.model.MovieItemDetails
import com.karim.domain.model.Movie

class MovieMapperImpl :MovieMapper{
    override fun toMovie(movieItemDetails: MovieItemDetails):Movie{
        return Movie(
            movieItemDetails.id,
            movieItemDetails.adult,
            movieItemDetails.poster_path,
            movieItemDetails.backdrop_path,
            movieItemDetails.title,
            movieItemDetails.overview,
            movieItemDetails.tagline,
            movieItemDetails.release_date,
            movieItemDetails.status,
            movieItemDetails.imdb_id,
            movieItemDetails.runtime.toString()
        )
    }
    override fun toMovieItem(movieItem: MovieItem):com.karim.domain.model.MovieItem{
        return com.karim.domain.model.MovieItem(
            movieItem.adult,
            movieItem.id
        )
    }
}
