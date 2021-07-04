package com.chethanbhandarkar.gnews.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.*
import com.chethanbhandarkar.gnews.data.repository.pagination.GoogleNewsPagingSource
import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService
import org.junit.Assert.*
import java.io.IOException
import javax.inject.Inject

class FakeGoogleNewsRepositoryTest @Inject constructor(private val googleNewsApiService: GoogleNewsApiService):GoogleNewsRepositoryInterface{

	override fun getSearchResults(query: String?): LiveData<PagingData<NewsData.Articles>> {
		return Pager(
			config = PagingConfig(
				pageSize = 10,
				maxSize = 100,
				enablePlaceholders = false,
				initialLoadSize = 10
			),
			pagingSourceFactory = {
				GoogleNewsPagingSource(googleNewsApiService, query)
			}
		).liveData


	}

}