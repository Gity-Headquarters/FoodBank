package com.gity.foodbank.utils

import android.content.Context
import android.text.Editable
import android.util.Patterns
import android.view.View
import android.widget.Toast

object CommonUtils {

//    Setting Loading
    fun loading(view: View, state: Boolean) {
        view.visibility = if (state) View.VISIBLE else View.GONE
    }

//    Untuk Memunculkan Toast
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun isValidEmail(email: Editable): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}