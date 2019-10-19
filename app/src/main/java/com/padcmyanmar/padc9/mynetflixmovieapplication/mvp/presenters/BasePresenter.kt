package com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padc9.mynetflixmovieapplication.mvp.views.BaseView

abstract class BasePresenter<T: BaseView>: ViewModel(){
    protected lateinit var mView: T

    open fun initPresenter(view: T) {
        mView = view
    }
}