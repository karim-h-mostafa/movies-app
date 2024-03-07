package com.karim.data.mapper

import com.karim.data.db.local.entity.CategoryEntity
import com.karim.data.db.remote.model.Genre
import com.karim.domain.model.Category
import com.karim.domain.model.Movie

interface CategoryEntityMapper {
    fun toCategoryEntity(category: Category): CategoryEntity
    fun toCategory(categoryEntity: CategoryEntity):Category
}