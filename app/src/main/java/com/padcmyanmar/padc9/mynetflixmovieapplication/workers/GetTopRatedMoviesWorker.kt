package com.padcmyanmar.padc9.mynetflixmovieapplication.workers

import android.content.Context
import androidx.work.WorkerParameters
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.dataAgents.RetrofitAgent

class GetTopRatedMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        RetrofitAgent.getTopRatedMovies(page = 1,
            onSuccess = {
                dataBase.movieDao().insertToTopRatedMovies(it)
                result = Result.success()
            }, onFailure = {
                result = Result.failure()
            }
        )
        return result
    }

}