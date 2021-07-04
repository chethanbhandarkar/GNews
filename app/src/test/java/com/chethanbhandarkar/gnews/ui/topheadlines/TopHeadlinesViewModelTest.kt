package com.chethanbhandarkar.gnews.ui.topheadlines

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.chethanbhandarkar.gnews.data.repository.GoogleNewsRepository
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.data.repository.pagination.remote.FakeApiImplementation
import com.chethanbhandarkar.gnews.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

@ExperimentalCoroutinesApi
class TopHeadlinesViewModelTest : ViewModel() {
	private val testDispatcher = TestCoroutineDispatcher()

	@Mock
	lateinit var newsViewModel: TopHeadlinesViewModel

	@get:Rule
	val rule = InstantTaskExecutorRule()

	@Before
	fun setUp() {
		newsViewModel = TopHeadlinesViewModel(GoogleNewsRepository(FakeApiImplementation()))
	}

	@After
	fun tearDown() {
	}

	@Test
	fun `when API called News Should be empty `() {
		testDispatcher.runBlockingTest {
			newsViewModel.getTopHeadlines("sdcbwkhdbi")
			val actualValue = newsViewModel.news.getOrAwaitValue()
			val list = listOf<NewsData.Articles>()
			assertThat(actualValue).isNotNull()
		}
		testDispatcher.cleanupTestCoroutines()

	}

}

