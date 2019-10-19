package com.padcmyanmar.padc9.mynetflixmovieapplication.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.*

interface MovieModel {

    fun getUpComingMovies(): LiveData<List<UpComingMoviesVo>>
    fun getPopularMovies(): LiveData<List<PopularMoviesVo>>
    fun getTopRatedMovies(): LiveData<List<TopRatedMoviesVo>>
    fun getSimilarMovies(movieId: Int): LiveData<List<SimilarMoviesVo>>
    fun getNowPlayingMovies(): LiveData<List<NowPlayingMovieVo>>

    fun getMovieById(id: Int): MovieVo
    fun searchMoviesByName(movieName: String): LiveData<List<MovieVo>>


}