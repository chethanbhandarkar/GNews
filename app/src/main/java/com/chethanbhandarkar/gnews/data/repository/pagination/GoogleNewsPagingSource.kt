package com.chethanbhandarkar.gnews.data.repository.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService
import retrofit2.HttpException
import java.io.IOException


private const val STARTING_PAGE_INDEX=1
class GoogleNewsPagingSource (
    private val googleNewsService:GoogleNewsApiService,
    private val query:String
    ): PagingSource<Int,NewsData.Articles>()
{


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsData.Articles> {

        val pagePosition=params.key?: STARTING_PAGE_INDEX
        Log.d("CHECKS pp",pagePosition.toString())

     return try {

         val queryresponse= googleNewsService.getTopHeadlinesSearch(page=pagePosition,pageSize = params.loadSize,query = query)


         val topHeadlines=queryresponse

         LoadResult.Page(
             data=topHeadlines.articles,
             prevKey = if(pagePosition== STARTING_PAGE_INDEX) null else pagePosition-1,
             nextKey = if(topHeadlines.articles.isEmpty()) null else pagePosition+1

         )

        }catch (exception:IOException)
       {
            LoadResult.Error(exception)

        }
        catch (exception:HttpException)
        {
            LoadResult.Error(exception)

        }

    }


    override fun getRefreshKey(state: PagingState<Int, NewsData.Articles>): Int? {
       return null
    }

}