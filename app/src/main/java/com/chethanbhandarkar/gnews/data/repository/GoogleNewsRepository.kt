package com.chethanbhandarkar.gnews.data.repository

import com.chethanbhandarkar.gnews.data.repository.remote.GoogleNewsApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleNewsRepository @Inject constructor(private val googleNewsApi:GoogleNewsApiService){


}