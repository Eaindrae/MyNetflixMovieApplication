package com.padcmyanmar.padc9.mynetflixmovieapplication.workers

import android.content.Context
import android.util.Log
import androidx.work.WorkerParameters
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.dataAgents.RetrofitAgent

class GetNowPlayingMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        RetrofitAgent.getNowPlayingMovies(page = 1,
            onSuccess = {
                dataBase.movieDao().insertToNowPlayingMovies(it)
                Log.d("Movies",it.toString())
                result = Result.success()
            }, onFailure = {
                result = Result.failure()
            }
        )
        return result
    }

}