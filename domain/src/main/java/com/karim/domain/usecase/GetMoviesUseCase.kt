package com.karim.domain.usecase

import com.karim.domain.repository.MoviesRepository

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke()=moviesRepository.getRemoteMovies()
}