package com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc9.mynetflixmovieapplication.activities.BaseActivity
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.models.MovieModelImpl
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MovieDelegate
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.views.DetailView
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.dataAgents.RetrofitAgent
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.DataBaseHelper

class DetailPresenter : BasePresenter<DetailView>(), MovieDelegate {

    override fun onItemClicked(movieId: Int) {
        mView.navigateToMovieDetail(movieId = movieId)
    }

    fun onPlayVideoButtonClicked(videoId: String?){
        if(videoId.isNullOrEmpty()){
            mView.showErrorMessage("Sorry!, This movie doesn't have any trailer video(s).")
        }
        else{
            mView.showTrailerVideoDialog()
        }
    }

    fun onUiReady(movieId: Int, activity: BaseActivity) {
        RetrofitAgent.getSimilarMovies(movieId, 1, {
            DataBaseHelper.movieDataBase.movieDao()
                .insertToSimilarMovies(movieList = it, movieId = movieId)
        }, {
            mView.showErrorMessage(it)
        })

        RetrofitAgent.getTrailerVideos(movieId = movieId,onSuccess = {
            val trailerVideoList = it.results
            if(trailerVideoList != null){
                if(trailerVideoList.isNotEmpty()){
                    mView.bindVideoData(trailerVideoList[0].key)
                }
            }else{
                mView.bindVideoData("")
            }
        },onFailure = {
            mView.showErrorMessage(it)
        })

        MovieModelImpl.getSimilarMovies(movieId).observe(activity, Observer { list ->
            if (list.isNotEmpty()) {
                val movieList = arrayListOf<MovieVo>()
                list.forEach {
                    movieList.add(it.movieVo)
                }
                mView.showSimilarMovies(movieList = movieList)
            }
            mView.bindMovieData(MovieModelImpl.getMovieById(movieId))
        })
    }
}