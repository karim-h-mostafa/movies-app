package com.karim.data.mapper

import com.karim.data.db.local.entity.MovieEntity
import com.karim.data.db.remote.model.MovieItemDetails
import com.karim.domain.model.Movie

class MovieEntityMapperImpl :MovieEntityMapper {
    override fun toMovieEntity(movieItemDetails: Movie): MovieEntity {
        return MovieEntity(
            movieItemDetails.id,
            movieItemDetails.adult,
            movieItemDetails.posterPath,
            movieItemDetails.backdropPath,
            movieItemDetails.title,
            movieItemDetails.overview,
            movieItemDetails.tagline,
            movieItemDetails.releaseDate,
            movieItemDetails.releaseStatus,
            movieItemDetails.imdb,
            movieItemDetails.duration
        )
    }
    override fun toMovie(movieEntity: MovieEntity):Movie{
        return Movie(
            movieEntity.id,
            movieEntity.adult,
            movieEntity.posterPath,
            movieEntity.backdropPath,
            movieEntity.title,
            movieEntity.overview,
            movieEntity.tagline,
            movieEntity.releaseDate,
            movieEntity.releaseStatus,
            movieEntity.imdb,
            movieEntity.duration
        )
    }
}