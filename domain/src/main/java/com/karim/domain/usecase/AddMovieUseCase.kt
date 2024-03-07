package com.karim.domain.usecase

import com.karim.domain.model.Movie
import com.karim.domain.repository.MoviesRepository

class AddMovieUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movie: Movie) = moviesRepository.addMovie(movie)
}