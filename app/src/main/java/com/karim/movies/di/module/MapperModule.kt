package com.karim.movies.di.module

import com.karim.data.mapper.CategoryEntityMapper
import com.karim.data.mapper.CategoryEntityMapperImpl
import com.karim.data.mapper.MovieCategoryEntityMapper
import com.karim.data.mapper.MovieCategoryEntityMapperImpl
import com.karim.data.mapper.MovieEntityMapper
import com.karim.data.mapper.MovieEntityMapperImpl
import com.karim.data.mapper.MovieMapper
import com.karim.data.mapper.MovieMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    fun movieEntityMapper():MovieEntityMapper{
        return MovieEntityMapperImpl()
    }
    @Provides
    fun categoryEntityMapper():CategoryEntityMapper{
        return CategoryEntityMapperImpl()
    }
    @Provides
    fun movieCategoryMapper():MovieCategoryEntityMapper{
        return MovieCategoryEntityMapperImpl()
    }
    @Provides
    fun movieMapper(): MovieMapper {
        return MovieMapperImpl()
    }

}