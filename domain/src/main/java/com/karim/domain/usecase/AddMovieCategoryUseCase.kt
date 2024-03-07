package com.karim.domain.usecase

import com.karim.domain.model.Category
import com.karim.domain.model.Movie
import com.karim.domain.model.MovieCategory
import com.karim.domain.repository.MoviesRepository

class AddMovieCategoryUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movieCategory: MovieCategory) = moviesRepository.addMovieCategory(movieCategory)
}