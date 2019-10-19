package com.padcmyanmar.padc9.mynetflixmovieapplication.workers

import android.content.Context
import androidx.work.WorkerParameters
import com.padcmyanmar.padc9.mynetflixmovieapplication.network.dataAgents.RetrofitAgent

class GetUpcomingMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        RetrofitAgent.getUpComingMovies(page = 1,
            onSuccess = {
                dataBase.movieDao().insertToUpcomingMovies(it)
                result = Result.success()
            }, onFailure = {
                result = Result.failure()
            }
        )
        return result
    }

}