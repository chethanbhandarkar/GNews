package com.chethanbhandarkar.gnews.ui.topheadlines

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.chethanbhandarkar.gnews.data.repository.GoogleNewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class TopHeadlinesViewModel @ViewModelInject constructor(private val repository: GoogleNewsRepository) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)


    val news=currentQuery.switchMap { queryString->
        Log.d("CHECKS currentquery",currentQuery.value.toString())
        repository.getSearchResults(queryString).cachedIn(viewModelScope)

    }

    fun getTopHeadlines(query:String){
        currentQuery.value=query

    }










    companion object{
        private val DEFAULT_QUERY:String="the"
    }



}