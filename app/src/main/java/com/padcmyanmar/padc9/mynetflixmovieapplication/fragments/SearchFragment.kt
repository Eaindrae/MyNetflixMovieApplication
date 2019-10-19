package com.padcmyanmar.padc9.mynetflixmovieapplication.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.padcmyanmar.padc9.mynetflixmovieapplication.R
import com.padcmyanmar.padc9.mynetflixmovieapplication.activities.BaseActivity
import com.padcmyanmar.padc9.mynetflixmovieapplication.adapters.MovieItemAdapter
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MainPresenterDelegate
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.presenters.MainPresenter
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : Fragment() {


    private lateinit var delegate: MainPresenterDelegate
    private lateinit var mPresenter: MainPresenter

    private lateinit var searchResultMoviesRecyclerAdapter: MovieItemAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MainPresenterDelegate
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        mPresenter = delegate.getPresenter()

        searchResultMoviesRecyclerAdapter = MovieItemAdapter(mPresenter,R.layout.item_movie_grid)
        val gridLayoutManager = GridLayoutManager(context, 3)
        with(view.rv_search_result) {
            adapter = searchResultMoviesRecyclerAdapter
            layoutManager = gridLayoutManager
        }
//        view.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                mPresenter.onSearchButtonClicked(query, activity as BaseActivity)
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                println("QUERYTEXT {$newText}")
//                if(newText.isNullOrEmpty()){
//                    searchResultMoviesRecyclerAdapter.data.clear()
//                    searchResultMoviesRecyclerAdapter.notifyDataSetChanged()
//                }
//
//                return false
//            }
//        })

        return view
    }

    fun setNewData(movieList: List<MovieVo>) {
        searchResultMoviesRecyclerAdapter.setNewData(movieList.toMutableList())
    }

}
