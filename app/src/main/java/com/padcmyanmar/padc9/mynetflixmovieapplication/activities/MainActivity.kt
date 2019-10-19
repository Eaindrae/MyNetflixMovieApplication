package com.padcmyanmar.padc9.mynetflixmovieapplication.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.padc9.mynetflixmovieapplication.R
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.MovieVo
import com.padcmyanmar.padc9.mynetflixmovieapplication.delegates.MainPresenterDelegate
import com.padcmyanmar.padc9.mynetflixmovieapplication.fragments.HomeFragment
import com.padcmyanmar.padc9.mynetflixmovieapplication.fragments.SearchFragment
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.presenters.MainPresenter
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_detail.*

class MainActivity : BaseActivity(), MainView, MainPresenterDelegate {

    private lateinit var mPresenter: MainPresenter

    private val HOME_TAG = "homeFragment"
    private val SEARCH_TAG = "searchFragment"
    val COMING_SOON_TAG = "commingSoonFragment"

    private val fragmentList = arrayListOf(
        HomeFragment(),
        SearchFragment(), HomeFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mPresenter.initPresenter(this)

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val transaction = supportFragmentManager.beginTransaction()
        if (supportFragmentManager.findFragmentByTag(HOME_TAG) == null) {
            transaction.add(R.id.main_content, fragmentList[0], HOME_TAG)
        }
        val currentFragment = supportFragmentManager.findFragmentById(R.id.main_content)
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        transaction.show(fragmentList[0])
        transaction.commit()

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val transaction = supportFragmentManager.beginTransaction()

            when (item.itemId) {
                R.id.action_home -> {
                    if (supportFragmentManager.findFragmentByTag(HOME_TAG) == null) {
                        transaction.add(R.id.main_content, fragmentList[0], HOME_TAG)
                    }
                    val currentFragment =
                        supportFragmentManager.findFragmentById(R.id.main_content)
                    if (currentFragment != null) {
                        transaction.hide(currentFragment)
                    }
                    transaction.show(fragmentList[0])
                    transaction.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_search -> {
                    if (supportFragmentManager.findFragmentByTag(SEARCH_TAG) == null) {
                        transaction.add(R.id.main_content,fragmentList[1],SEARCH_TAG)
                    }
                    val currentFragment = supportFragmentManager.findFragmentById(R.id.main_content)
                    if(currentFragment!=null)
                    {
                        transaction.hide(currentFragment)
                    }
                    transaction.show(fragmentList[1])
                    transaction.commit()
                    return@OnNavigationItemSelectedListener true

                }
                R.id.action_coming_soon -> return@OnNavigationItemSelectedListener true
                R.id.action_download -> return@OnNavigationItemSelectedListener true
                R.id.action_more -> return@OnNavigationItemSelectedListener true
            }
            false
        }

    override fun showResultMovieList(movieList: List<MovieVo>) {
        val fragment =  supportFragmentManager.findFragmentByTag(SEARCH_TAG)
        if(fragment!=null){
            val searchFragment = fragment as SearchFragment
            searchFragment.setNewData(movieList)
        }
    }

    override fun showMainMovieList(movieList: List<List<MovieVo>>) {
        val fragment =  supportFragmentManager.findFragmentByTag(HOME_TAG)
        if(fragment!=null){
            val homeFragment = fragment as HomeFragment
            homeFragment.setNewData(movieList)
        }
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(MovieDetailActivity.newIntent(this,movieId))
    }

    override fun getPresenter(): MainPresenter {
        return mPresenter
    }
//rootView
    override fun showErrorMessage(message: String) {
        showSnackBar(message,View)
    }
}
