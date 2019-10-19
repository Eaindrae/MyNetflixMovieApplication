package com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.views

import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo

interface DetailView : BaseView {

    fun bindMovieData(movieVo: MovieVo)
    fun showSimilarMovies(movieList: List<MovieVo>)
    fun navigateToMovieDetail(movieId: Int)
    fun showErrorMessage(message: String)
    fun bindVideoData(videoId:String?)
    fun showTrailerVideoDialog()
}