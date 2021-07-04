package com.chethanbhandarkar.gnews.data.repository.pagination.remote

import android.util.Log
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService

class FakeApiImplementation:GoogleNewsApiService {

	init{

	}
	companion object{}

	override suspend fun getTopHeadlines(
		source: String,
		page: Int,
		pageSize: Int,
		apiKey: String
	): NewsData {

		return NewsData("",10, listOf(NewsData.Articles(NewsData.Articles.Source("1","sws"),"","dw","WDW","wdwd","WSDw","WDwd","efe")
				,NewsData.Articles(NewsData.Articles.Source("2","sws"),"","dw","WDW","wdwd","WSDw","WDwd","efe"),

		))

	}

	override suspend fun getTopHeadlinesSearch(
		page: Int,
		pageSize: Int,
		apiKey: String,
		query: String
	): NewsData {
		return NewsData("",10, listOf(NewsData.Articles(NewsData.Articles.Source("1","sws"),"","dw","WDW","wdwd","WSDw","WDwd","efe")
			,NewsData.Articles(NewsData.Articles.Source("2","sws"),"","dw","WDW","wdwd","WSDw","WDwd","efe")
		))

	}
}