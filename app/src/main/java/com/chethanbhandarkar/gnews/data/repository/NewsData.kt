package com.chethanbhandarkar.gnews.data.repository

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsData (

    @SerializedName("status")
    val status: String = "",

    @SerializedName("totalResults")
    val totalResults: Int = 0,

    @SerializedName("articles")
    val articles: List<Articles> = emptyList()
) :Parcelable{
    @Parcelize
    data class Articles(
        @SerializedName("source")
        val source: Source,

        @SerializedName("author")
        val author: String? = null,

        @SerializedName("title")
        val title: String? = null,

        @SerializedName("description")
        val description: String? = null,

        @SerializedName("url")
        val url: String? = null,

        @SerializedName("urlToImage")
        val urlToImage: String? = null,


        @SerializedName("publishedAt")
        val publishedAt: String? = null,

        @SerializedName("content")
        val content: String? = null

    ):Parcelable
        @Parcelize
        data class Source(
        @SerializedName("id")
        val id: String? = null,

        @SerializedName("name")
        val name: String? = null
    ):Parcelable





}

