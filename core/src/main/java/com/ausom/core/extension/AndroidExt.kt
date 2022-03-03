package com.ausom.core.extension

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/**
 *  Simplified call for setting visibility depending on [show]
 */
infix fun View.showIf(show: Boolean?) {
    visibility = if(show == true) View.VISIBLE else View.GONE
}

/**
 *  Closes the keyboard when called
 */
fun Fragment.hideKeyboard() {
    try {
        val activity = requireActivity()
        val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocusedView = activity.currentFocus
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}