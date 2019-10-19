package com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.views

import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo

interface MainView:BaseView {

    //homeFragment
    fun showMainMovieList(movieList: List<List<MovieVo>>)

    //searchFragment
    fun showResultMovieList(movieList: List<MovieVo>)

    fun navigateToMovieDetail(movieId: Int)
    fun showErrorMessage(message: String)



}