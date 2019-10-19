package com.padcmyanmar.padc9.mynetflixmovieapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.mynetflixmovieapplication.R
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MovieDelegate
import com.padcmyanmar.padc9.mynetflixmovieapplication.viewholders.BaseViewHolder
import com.padcmyanmar.padc9.mynetflixmovieapplication.viewholders.MovieListViewHolder

class HomeMovieListRecyclerAdapter(private val delegate: MovieDelegate)
    : BaseAdapter<BaseViewHolder<List<MovieVo>>, List<MovieVo>>() {
    private val vtNowPlaying = 0
    private val vtPopular = 1
    private val vtTopRated = 2
    private val vtUpcoming = 3

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<List<MovieVo>> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_movie_list_home, parent, false)
        return when (viewType) {
            vtNowPlaying -> {
                MovieListViewHolder(view, "Now Playing",delegate)
            }
            vtPopular -> {
                MovieListViewHolder(view, "Critically-acclaimed Western TV Shows",delegate)
            }
            vtTopRated -> {
                MovieListViewHolder(view, "Netflix Originals",delegate)
            }
            else -> {
                MovieListViewHolder(view, "Top pick For Thet",delegate)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return when (position) {
            0 -> vtNowPlaying
            1 -> vtPopular
            2 -> vtTopRated
            else -> vtUpcoming
        }
    }
}