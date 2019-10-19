package com.padcmyanmar.padc9.mynetflixmovieapplication.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.padcmyanmar.padc9.mynetflixmovieapplication.R
import com.padcmyanmar.padc9.mynetflixmovieapplication.activities.BaseActivity
import com.padcmyanmar.padc9.mynetflixmovieapplication.adapters.HomeMovieListRecyclerAdapter
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MainPresenterDelegate
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.presenters.MainPresenter
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var delegate: MainPresenterDelegate
    private lateinit var mPresenter: MainPresenter

    private lateinit var homeMovieListRecyclerAdapter: HomeMovieListRecyclerAdapter
    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MainPresenterDelegate
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        mPresenter = delegate.getPresenter()

        homeMovieListRecyclerAdapter = HomeMovieListRecyclerAdapter(mPresenter)

        val linearLayoutManager = LinearLayoutManager(context)
        with(view.rv_movies_list_home){
            adapter = homeMovieListRecyclerAdapter
            layoutManager = linearLayoutManager
        }
        mPresenter.onUiReady(activity as BaseActivity)
        return  view
    }

    fun setNewData(movieList: List<List<MovieVo>>) {
        homeMovieListRecyclerAdapter.setNewData(movieList.toMutableList())
    }

}
