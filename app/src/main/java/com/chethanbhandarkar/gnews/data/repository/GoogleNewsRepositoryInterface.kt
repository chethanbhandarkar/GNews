package com.chethanbhandarkar.gnews.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

interface GoogleNewsRepositoryInterface {



	fun getSearchResults(query: String?): LiveData<PagingData<NewsData.Articles>>


}