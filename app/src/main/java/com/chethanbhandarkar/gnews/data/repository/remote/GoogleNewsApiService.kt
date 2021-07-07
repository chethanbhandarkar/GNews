package com.chethanbhandarkar.gnews.data.repository.remote

import com.chethanbhandarkar.gnews.BuildConfig
import com.chethanbhandarkar.gnews.data.repository.NewsData
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleNewsApiService {
	companion object {
		const val BASE_URL = "https://newsapi.org/"
		const val CLIENT_ID = BuildConfig.NEWSORG_ACCESS_KEY
	}

	@GET("v2/top-headlines")
	suspend fun getTopHeadlines(
		@Query("sources") source: String = "google-news",
		@Query("page") page: Int,
		@Query("pageSize") pageSize: Int,
		@Query("apiKey") apiKey: String = CLIENT_ID
	): NewsData

	@GET("v2/everything")
	suspend fun getTopHeadlinesSearch(
		@Query("page") page: Int,
		@Query("pageSize") pageSize: Int,
		@Query("apiKey") apiKey: String = CLIENT_ID,
		@Query("q") query: String,
		@Query("sortBy")sort:String="publishedAt"
	): NewsData

}