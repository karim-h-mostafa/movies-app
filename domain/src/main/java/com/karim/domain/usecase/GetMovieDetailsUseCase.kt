package com.karim.domain.usecase

import com.karim.domain.repository.MoviesRepository

class GetMovieDetailsUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movieId:Long)=moviesRepository.getMovieDetails(movieId)
}