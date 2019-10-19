package com.padcmyanmar.padc9.mynetflixmovieapplication.network.dataAgents

import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses.TrailerVideoResponse

interface MovieDataAgent {
    fun getNowPlayingMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getPopularMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTopRatedMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getSimilarMovies(
        movieId: Int,
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getUpComingMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun searchMovies(
        query: String,
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTrailerVideos(
        movieId: Int,
        onSuccess: (TrailerVideoResponse) -> Unit,
        onFailure: (String) -> Unit
    )




}