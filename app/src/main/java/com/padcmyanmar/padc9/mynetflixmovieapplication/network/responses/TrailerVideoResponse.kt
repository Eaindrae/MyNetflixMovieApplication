package com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.TrailerVideoVo

data class TrailerVideoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<TrailerVideoVo>?
)