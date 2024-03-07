package com.karim.domain.usecase

import com.karim.domain.repository.MoviesRepository

class GetRemoteMovieDetailsUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movieId:Long)=moviesRepository.getRemoteMovieDetails(movieId)
}