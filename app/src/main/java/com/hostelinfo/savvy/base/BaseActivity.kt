package com.hostelinfo.savvy.base

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun uiHandle()
    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun hideToolbar() {
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {

        }
    }

    protected fun hideKeyBoard(activity: Activity) {
        val view = activity?.currentFocus ?: View(activity)
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}