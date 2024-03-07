package com.karim.domain.usecase

import com.karim.domain.model.Category
import com.karim.domain.model.Movie
import com.karim.domain.repository.MoviesRepository

class AddCategoryUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(category: Category) = moviesRepository.addCategory(category)
}