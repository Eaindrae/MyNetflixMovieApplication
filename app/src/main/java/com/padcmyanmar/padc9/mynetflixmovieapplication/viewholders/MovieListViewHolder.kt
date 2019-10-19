package com.padcmyanmar.padc9.mynetflixmovieapplication.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padc9.mynetflixmovieapplication.R
import com.padcmyanmar.padc9.mynetflixmovieapplication.adapters.MovieItemAdapter
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MovieDelegate
import kotlinx.android.synthetic.main.layout_movie_list_home.view.*

class MovieListViewHolder(itemView: View, private val title: String, private val delegate: MovieDelegate) : BaseViewHolder<List<MovieVo>>(itemView) {


    override fun bindData(data: List<MovieVo>) {
        itemView.layoutTitle.text = title
        val linearLayoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
        val movieItemAdapter = MovieItemAdapter(delegate, R.layout.item_movie)
        movieItemAdapter.setNewData(data.toMutableList())
        with(itemView.rvItemMovieList){
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = movieItemAdapter
        }


    }


}