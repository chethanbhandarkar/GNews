package com.chethanbhandarkar.gnews.data.repository.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class GoogleNewsPagingSource(
	private val googleNewsService: GoogleNewsApiService,
	private val query: String? = null
) : PagingSource<Int, NewsData.Articles>() {
	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsData.Articles> {
		val pagePosition = params.key ?: STARTING_PAGE_INDEX

		return try {
			val queryResponse: NewsData = if (query.isNullOrEmpty()) {
				googleNewsService.getTopHeadlines(
					page = pagePosition,
					pageSize = params.loadSize
				)
			} else {
				googleNewsService.getTopHeadlinesSearch(
					page = pagePosition,
					pageSize = params.loadSize,
					query = query
				)
			}
            LoadResult.Page(
                data = queryResponse.articles,
                prevKey = if (pagePosition == STARTING_PAGE_INDEX) null else pagePosition - 1,
                nextKey = if (queryResponse.articles.isEmpty()) null else pagePosition + 1
            )

		} catch (exception: IOException) {
			LoadResult.Error(exception)

		} catch (exception: HttpException) {
			LoadResult.Error(exception)

		}

	}

	override fun getRefreshKey(state: PagingState<Int, NewsData.Articles>): Int? {
		return null
	}

}