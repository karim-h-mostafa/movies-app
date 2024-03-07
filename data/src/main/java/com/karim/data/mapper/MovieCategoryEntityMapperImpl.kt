package com.karim.data.mapper

import com.karim.data.db.local.entity.CategoryEntity
import com.karim.data.db.local.entity.MovieCategoryCrossRef
import com.karim.data.db.remote.model.Genre
import com.karim.domain.model.Category
import com.karim.domain.model.Movie
import com.karim.domain.model.MovieCategory

class MovieCategoryEntityMapperImpl:MovieCategoryEntityMapper {
    override fun toMovieCategoryEntity(movieCategory: MovieCategory): MovieCategoryCrossRef {
        return MovieCategoryCrossRef (
            movieCategory.movieId,
            movieCategory.categoryId
        )
    }

}