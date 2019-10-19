package com.padcmyanmar.padc9.mynetflixmovieapplication.activities

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity: AppCompatActivity() {

    protected fun showSnackBar(message: String,rootView: View) {
        val snackBar = Snackbar.make(rootView, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("OK") { snackBar.dismiss() }
        snackBar.show()
    }
}