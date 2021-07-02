package com.chethanbhandarkar.gnews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.chethanbhandarkar.gnews.data.repository.pagination.GoogleNewsPagingSource
import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleNewsRepository @Inject constructor(private val googleNewsApi:GoogleNewsApiService){

    fun getSearchResults(query:String)=
        Pager(
            config= PagingConfig(
                pageSize = 5,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {


                    GoogleNewsPagingSource(googleNewsApi,query)

            }

        ).liveData



}