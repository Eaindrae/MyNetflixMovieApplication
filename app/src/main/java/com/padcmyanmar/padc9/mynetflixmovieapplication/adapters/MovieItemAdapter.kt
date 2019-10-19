package com.padcmyanmar.padc9.mynetflixmovieapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MovieDelegate
import com.padcmyanmar.padc9.mynetflixmovieapplication.viewholders.MovieItemViewHolder

class MovieItemAdapter(private val delegate: MovieDelegate, private val layoutId: Int) :
    BaseAdapter<MovieItemViewHolder, MovieVo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MovieItemViewHolder(view, delegate)
    }

}