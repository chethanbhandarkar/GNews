package com.chethanbhandarkar.gnews.data.repository.pagination


import androidx.paging.PagingSource
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.data.repository.pagination.remote.FakeApiImplementation
import com.google.common.truth.Truth.assertThat
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GoogleNewsPagingSourceTest{
	lateinit var fakeNewsData:NewsData
	private val mockApi = FakeApiImplementation()
	private val getFakeData=runBlockingTest{
		 fakeNewsData=mockApi.getTopHeadlines(" ",1,1,"fakeKey")
	}
	private val fakeNewsDataArticle=fakeNewsData.articles


    @Test
	fun `check Paging Source default search`()= runBlockingTest {

		val pagingSource=GoogleNewsPagingSource(mockApi,null)

		assertThat(
			PagingSource.LoadResult.Page(
				data = listOf(fakeNewsDataArticle[0], fakeNewsDataArticle[1]),
			    prevKey=null,
				nextKey = 2
			)).isEqualTo(
			pagingSource.load(

			PagingSource.LoadParams.Refresh(
				key=null,
				loadSize = 2,
				placeholdersEnabled = false
			))
		)




	}






}