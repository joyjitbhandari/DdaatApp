package com.example.ddaatapp.utils

import android.app.ProgressDialog
import android.content.Context
import android.view.View
import android.widget.Toast


private var progressDialog: ProgressDialog? = null

//fun Context.showProgressDialog() {
//    if (progressDialog == null) {
//        progressDialog = ProgressDialog(this)
//        progressDialog?.setMessage("Loading...")
//        progressDialog?.isIndeterminate = true
//    }
//    progressDialog?.show()
//}
//
//fun hideProgressDialog() {
//    progressDialog?.dismiss()
//    progressDialog = null
//}

fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.setInVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.INVISIBLE else View.VISIBLE
}

fun Context.showToast(msg: Any, duration: Int = Toast.LENGTH_SHORT) {
    when (msg) {
        is Int -> {
            Toast.makeText(this, getString(msg), duration).show()
        }

        is String -> {
            Toast.makeText(this, msg, duration).show()
        }
    }
}

