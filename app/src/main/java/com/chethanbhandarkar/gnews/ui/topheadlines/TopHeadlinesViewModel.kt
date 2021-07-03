package com.chethanbhandarkar.gnews.ui.topheadlines

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.chethanbhandarkar.gnews.data.repository.GoogleNewsRepository

class TopHeadlinesViewModel @ViewModelInject constructor(
	private val repository: GoogleNewsRepository,
	@Assisted state: SavedStateHandle
) : ViewModel() {
	// private val currentQuery = MutableLiveData(DEFAULT_QUERY)
	private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)
	val news = currentQuery.switchMap { queryString ->
		repository.getSearchResults(queryString).cachedIn(viewModelScope)
	}

	fun getTopHeadlines(query: String) {
		currentQuery.value = query

	}

	companion object {
		private val DEFAULT_QUERY: String? = null
		private val CURRENT_QUERY: String = "current_query"
	}

}