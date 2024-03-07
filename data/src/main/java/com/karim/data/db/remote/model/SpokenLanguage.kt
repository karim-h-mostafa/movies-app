package com.karim.data.db.remote.model

import androidx.room.PrimaryKey

data class SpokenLanguage(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val english_name: String,
    val iso_639_1: String,
    val name: String
)