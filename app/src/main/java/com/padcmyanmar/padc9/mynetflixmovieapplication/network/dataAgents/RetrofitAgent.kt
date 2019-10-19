package com.padcmyanmar.padc9.mynetflixmovieapplication.network.dataAgents

import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.MovieApi
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses.MovieResponse
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses.MovieResponseWithDate
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.responses.TrailerVideoResponse
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitAgent : MovieDataAgent {

    private val MOVIE_API: MovieApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        MOVIE_API = retrofit.create(MovieApi::class.java)
    }

    override fun getTrailerVideos(
        movieId: Int,
        onSuccess: (TrailerVideoResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val fullUrl = URL_GET_MOVIES_PREFIX + movieId + URL_GET_VIDEOS_POSTFIX
        val call = MOVIE_API.getTrailerVideos(fullUrl = fullUrl)
        call.enqueue(object : Callback<TrailerVideoResponse> {
            override fun onFailure(call: Call<TrailerVideoResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<TrailerVideoResponse>,
                response: Response<TrailerVideoResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse)
                } else {
                    onFailure(NULL_RESPONSE)
                }
            }

        })
    }

    override fun searchMovies(
        query: String,
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = MOVIE_API.getSearchMovies(page = page, query = query)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(NULL_RESPONSE)
                }
            }

        })
    }

    override fun getNowPlayingMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = MOVIE_API.getNowPlayingMovies(page)
        call.enqueue(object : Callback<MovieResponseWithDate> {
            override fun onFailure(call: Call<MovieResponseWithDate>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MovieResponseWithDate>,
                response: Response<MovieResponseWithDate>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(NULL_RESPONSE)
                }
            }

        })
    }

    override fun getPopularMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = MOVIE_API.getPopularMovies(page)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(NULL_RESPONSE)
                }
            }

        })
    }

    override fun getTopRatedMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = MOVIE_API.getTopRatedMovies(page)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(NULL_RESPONSE)
                }
            }

        })
    }

    override fun getSimilarMovies(
        movieId: Int,
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val fullUrl = URL_GET_MOVIES_PREFIX + movieId + URL_GET_SIMILAR_MOVIES_POSTFIX
        val call = MOVIE_API.getSimilarMovies(fullUrl = fullUrl, page = page)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(NULL_RESPONSE)
                }
            }

        })
    }

    override fun getUpComingMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = MOVIE_API.getUpComingMovies(page)
        call.enqueue(object : Callback<MovieResponseWithDate> {
            override fun onFailure(call: Call<MovieResponseWithDate>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MovieResponseWithDate>,
                response: Response<MovieResponseWithDate>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(NULL_RESPONSE)
                }
            }

        })
    }
}