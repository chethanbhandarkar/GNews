package com.chethanbhandarkar.gnews.data.repository.remote

import android.util.Log
import com.chethanbhandarkar.gnews.BuildConfig
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.data.repository.pagination.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleNewsApiService {

//v2/top-headlines?sources=google-news&pageSize=5&page=1&apiKey=adb6e6084586456a9be035dae41c0a67

    companion object{
       const val BASE_URL="https://newsapi.org/"
       const val CLIENT_ID=BuildConfig.NEWSORG_ACCESS_KEY
    }

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(@Query("source") source:String="google-news",
                                @Query("page")page:Int,
                                @Query("pageSize")pageSize:Int,
                                @Query("apiKey") apiKey:String= CLIENT_ID)
    :NewsData


    @GET("v2/top-headlines")

    suspend fun getTopHeadlinesSearch(@Query("source") source:String="google-news",
                                @Query("page")page:Int,
                                @Query("pageSize")pageSize:Int,
                                @Query("apiKey") apiKey:String= CLIENT_ID,
                                @Query("q")query:String
    ):NewsData







}