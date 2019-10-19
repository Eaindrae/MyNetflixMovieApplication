package com.padcmyanmar.padc9.mynetflixmovieapplication

import android.app.Application
import androidx.work.*
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.DataBaseHelper
import com.padcmyanmar.padc9.mynetflixmovieapplication.workers.GetNowPlayingMoviesWorker
import com.padcmyanmar.padc9.mynetflixmovieapplication.workers.GetPopularMoviesWorker
import com.padcmyanmar.padc9.mynetflixmovieapplication.workers.GetTopRatedMoviesWorker
import com.padcmyanmar.padc9.mynetflixmovieapplication.workers.GetUpcomingMoviesWorker
import java.util.concurrent.TimeUnit

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBaseHelper.initDatabase(this)
        getNowPlaying()
        getPopular()
        getTopRated()
        getUpcoming()
        getNowPlayingPeriodically()
        getPopularPeriodically()
        getTopRatedPeriodically()
        getUpcomingPeriodically()
    }

    private fun getNowPlaying() {
        val getNowShowingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowShowingMoviesWorkRequest)
    }
    private fun getTopRated() {
        val getTopRatedMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopular() {
        val getPopularMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetPopularMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcoming() {
        val getUpComingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }

    private fun getNowPlayingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getNowShowingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowShowingMoviesWorkRequest)
    }
    private fun getTopRatedPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getTopRatedMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopularPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getPopularMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetPopularMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcomingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getUpComingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }

}