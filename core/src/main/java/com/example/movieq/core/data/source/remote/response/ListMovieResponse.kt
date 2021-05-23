package com.example.movieq.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Long,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("results")
    val results: List<MovieResponse>
)