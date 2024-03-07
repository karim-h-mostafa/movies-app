package com.karim.data.mapper

import com.karim.data.db.local.entity.CategoryEntity
import com.karim.domain.model.Category
import com.karim.domain.model.Movie

class CategoryEntityMapperImpl :CategoryEntityMapper{
    override fun toCategoryEntity(category: Category): CategoryEntity {
        return CategoryEntity (
            category.id,
            category.name
        )
    }
    override fun toCategory(categoryEntity: CategoryEntity):Category{
        return Category(
            categoryEntity.id,
            categoryEntity.name,
            categoryEntity.movies.map { Movie(
                it.id,
                it.adult,
                it.posterPath,
                it.backdropPath,
                it.title,
                it.overview,
                it.tagline,
                it.releaseDate,
                it.releaseStatus,
                it.imdb,
                it.duration
            ) }
        )
    }
}