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
    private val query:String?=null
    ): PagingSource<Int,NewsData.Articles>()
{


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsData.Articles> {

        val pagePosition=params.key?: STARTING_PAGE_INDEX
        Log.d("CHECKS pp",pagePosition.toString())

     return try {
         lateinit var queryResponse:NewsData
         Log.d("checks null",query.isNullOrEmpty().toString())
         if(query.isNullOrEmpty())
         {
             queryResponse= googleNewsService.getTopHeadlines(page=pagePosition,pageSize = params.loadSize)
             Log.d("checks","normalsearch")
         }
         else{
             queryResponse= googleNewsService.getTopHeadlinesSearch(page=pagePosition,pageSize = params.loadSize,query = query)
             Log.d("checks","querysearch")

         }



         val topHeadlines=queryResponse
         Log.d("checks TQ",topHeadlines.articles.size.toString())

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