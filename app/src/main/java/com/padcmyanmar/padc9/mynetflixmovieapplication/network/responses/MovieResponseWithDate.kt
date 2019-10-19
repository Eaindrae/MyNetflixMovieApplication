package com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.DateVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo

data class MovieResponseWithDate(
    @SerializedName("page")
    val page:Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("dates")
    val dates: DateVo,
    @SerializedName("results")
    val results: List<MovieVo>)