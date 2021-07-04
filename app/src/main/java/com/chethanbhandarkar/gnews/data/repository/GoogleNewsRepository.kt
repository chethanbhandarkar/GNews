package com.chethanbhandarkar.gnews.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.chethanbhandarkar.gnews.data.repository.pagination.GoogleNewsPagingSource
import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleNewsRepository @Inject constructor(private val googleNewsApi: GoogleNewsApiService):GoogleNewsRepositoryInterface {
	override fun getSearchResults(query: String?) =
		Pager(
			config = PagingConfig(
				pageSize = 10,
				maxSize = 100,
				enablePlaceholders = false,
				initialLoadSize = 10
			),
			pagingSourceFactory = {
				GoogleNewsPagingSource(googleNewsApi, query)
			}
		).liveData

}