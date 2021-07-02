package com.chethanbhandarkar.gnews.data.repository.pagination

import com.chethanbhandarkar.gnews.data.repository.NewsData

data class NewsResponse (

val articles: List<NewsData.Articles>

)