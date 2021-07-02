package com.chethanbhandarkar.gnews.ui.topheadlines

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TopHeadlinesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    fun getTopHeadlines(){

        viewModelScope.launch {


        }




    }



}