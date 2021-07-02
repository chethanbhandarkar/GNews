package com.chethanbhandarkar.gnews.di

import android.app.Application
import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit=
        Retrofit.Builder()
            .baseUrl(GoogleNewsApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGoogleNewsApiService(retrofit: Retrofit):GoogleNewsApiService=
        retrofit.create(GoogleNewsApiService::class.java)
}