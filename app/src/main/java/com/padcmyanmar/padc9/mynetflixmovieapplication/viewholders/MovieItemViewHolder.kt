package com.padcmyanmar.padc9.mynetflixmovieapplication.viewholders

import android.view.View
import coil.api.load
import com.padcmyanmar.padc9.mynetflixmovieapplication.R
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MovieDelegate
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.IMAGE_PATH
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieItemViewHolder(itemView: View, private val delegate: MovieDelegate) : BaseViewHolder<MovieVo>(itemView) {
    init {
        itemView.setOnClickListener {
            data?.id?.let { movieId -> delegate.onItemClicked(movieId) }
        }
    }
    override fun bindData(data: MovieVo) {
        itemView.iv_item_movie_one.load(IMAGE_PATH + data.posterPath){
            placeholder(R.mipmap.netfilx)
        }
    }

}