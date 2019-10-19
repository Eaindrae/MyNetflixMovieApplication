package com.padcmyanmar.padc9.mynetflixmovieapplication.network

import com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses.MovieResponse
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses.MovieResponseWithDate
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses.TrailerVideoResponse
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {

    @GET(URL_GET_NOW_PLAYING)
    fun getNowPlayingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponseWithDate>

    @GET(URL_GET_POPULAR)
    fun getPopularMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponse>

    @GET(URL_GET_TOP_RATED)
    fun getTopRatedMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponse>

    @GET(URL_GET_UPCOMING)
    fun getUpComingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponseWithDate>

    @GET
    fun getSimilarMovies(@Url fullUrl: String, @Query(PARAM_PAGE) page:Int = 1): Call<MovieResponse>

    @GET
    fun getTrailerVideos(@Url fullUrl: String): Call<TrailerVideoResponse>

    @GET(URL_GET_SEARCH_MOVIES)
    fun getSearchMovies(@Query(PARAM_PAGE) page:Int = 1,@Query(PARAM_QUERY) query: String): Call<MovieResponse>

}