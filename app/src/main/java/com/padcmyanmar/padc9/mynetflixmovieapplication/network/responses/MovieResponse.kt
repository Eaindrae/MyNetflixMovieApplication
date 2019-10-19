package com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo

data class MovieResponse(
    @SerializedName("page")
    val page:Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<MovieVo>)