package com.karim.movies.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MoviesApplication:Application() {
    override fun onCreate() {
        super.onCreate()

    }
}