package com.chethanbhandarkar.gnews.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.chethanbhandarkar.gnews.data.repository.GoogleNewsRepository
import com.chethanbhandarkar.gnews.data.repository.NewsData

class DashboardViewModel @ViewModelInject constructor(private val repository: GoogleNewsRepository): ViewModel() {

	private val currentQuery=MutableLiveData(CURRENT_QUERY)


	val news=currentQuery.switchMap {
		repository.getSearchResults(it).cachedIn(viewModelScope)


	}

	companion object {
		private val DEFAULT_QUERY: String? = null
		private val CURRENT_QUERY: String = "India"
	}


}