package com.padcmyanmar.padc9.mynetflixmovieapplication.utils

import android.content.Context
import com.padcmyanmar.padc9.mynetflixmovieapplication.persistence.MovieDataBase

object DataBaseHelper {


    lateinit var movieDataBase: MovieDataBase

    fun initDatabase(context: Context) {
        movieDataBase = MovieDataBase.getInstance(context)
    }
}