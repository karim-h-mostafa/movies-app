package com.karim.data.db.local.dao

interface DaoProvider {
    fun movieDao():MovieDao
    fun categoryDao():CategoryDao
    fun movieCategoryDao():MovieCategoryCrossRefDao
}