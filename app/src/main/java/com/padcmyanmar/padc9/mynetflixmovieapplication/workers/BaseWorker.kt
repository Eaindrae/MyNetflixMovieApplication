package com.padcmyanmar.padc9.mynetflixmovieapplication.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.DataBaseHelper

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    protected val dataBase = DataBaseHelper.movieDataBase
}