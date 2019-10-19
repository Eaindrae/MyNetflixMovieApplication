package com.padcmyanmar.padc9.mynetflixmovieapplication.delegates

import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.presenters.MainPresenter

interface MainPresenterDelegate {

    fun getPresenter(): MainPresenter

}