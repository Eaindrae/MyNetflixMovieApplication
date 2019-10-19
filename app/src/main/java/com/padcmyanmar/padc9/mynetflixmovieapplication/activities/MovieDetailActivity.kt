package com.padcmyanmar.padc9.mynetflixmovieapplication.activities

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import coil.transform.BlurTransformation
import com.padcmyanmar.padc9.mynetflixmovieapplication.R
import com.padcmyanmar.padc9.mynetflixmovieapplication.adapters.MovieItemAdapter
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.presenters.DetailPresenter
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.views.DetailView
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.IMAGE_PATH
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.layout_youtube_video_player.view.*

class MovieDetailActivity : BaseActivity(), DetailView {

    companion object {
        private const val IE_MOVIE = "intentMovie"
        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_MOVIE, id)
            return intent
        }
    }

    private lateinit var mPresenter: DetailPresenter

    private var videoId: String? = ""
    private lateinit var movieItemAdapter: MovieItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mPresenter.initPresenter(this)

        movieItemAdapter = MovieItemAdapter(mPresenter, R.layout.item_movie)
        mPresenter.onUiReady(intent.getIntExtra(IE_MOVIE, 0), this)

        btn_play.setOnClickListener {
            mPresenter.onPlayVideoButtonClicked(videoId)
        }

        btn_cross.setOnClickListener {
            finish()
        }
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        with(rv_detail) {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = movieItemAdapter
        }

    }

    private fun showTrailerVideoDialog(videoId: String) {
        val mDialogView =
            LayoutInflater.from(this).inflate(R.layout.layout_youtube_video_player, null)
        lifecycle.addObserver(mDialogView.youTubePlayerView)
        mDialogView.youTubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        AlertDialog.Builder(this)
            .setView(mDialogView)
            .show()
    }

    override fun showTrailerVideoDialog() {
        showTrailerVideoDialog(videoId!!)
    }

    override fun bindVideoData(videoId: String?) {
        this.videoId = videoId
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(newIntent(this, movieId))
    }

    override fun bindMovieData(movieVo: MovieVo) {
        iv_bg_poseter_detail.load(IMAGE_PATH + movieVo.posterPath) {
            transformations(BlurTransformation(this@MovieDetailActivity, 10f))
        }
        iv_poster_detail.load(IMAGE_PATH + movieVo.posterPath)
        tv_year.text = movieVo.releaseDate
        //tv_detail_description.text = movieVo.overview
    }

    override fun showSimilarMovies(movieList: List<MovieVo>) {
        movieItemAdapter.setNewData(movieList.toMutableList())
    }
//rootView
    override fun showErrorMessage(message: String) {
        showSnackBar(message,View)
    }

}
