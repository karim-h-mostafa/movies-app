package com.karim.movies.di.module

import com.karim.data.db.remote.api.MoviesAPI
import com.karim.movies.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor {
            Timber.tag(Constants.LOGGER_TAG).d(it)
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun headerInterceptor(): Interceptor {
        return Interceptor {
            val timeoutSeconds = 10000
            val request = it.request()
            val requestBuilder = request.newBuilder()
            requestBuilder
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Timeout", timeoutSeconds.toString())
            it.proceed(requestBuilder.build())
        }
    }

    @Provides
    fun okHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor).build()
    }

    @Provides
    fun retrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun movieApi(retrofit: Retrofit): MoviesAPI {
        return retrofit.create(MoviesAPI::class.java)
    }
}