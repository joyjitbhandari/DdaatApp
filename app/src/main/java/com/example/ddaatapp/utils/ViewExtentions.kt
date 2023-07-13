package com.example.ddaatapp.utils

import android.app.ProgressDialog
import android.content.Context
import android.view.View
import android.widget.Toast

private var mProgressDialog: ProgressDialog? = null

fun showProgressDialog(context: Context) {
    if (mProgressDialog == null) {
        mProgressDialog = ProgressDialog(context)
        mProgressDialog!!.setMessage("Loading ...")
        mProgressDialog!!.isIndeterminate = true
    }
    mProgressDialog!!.show()
}

fun hideProgressDialog() {
    if (mProgressDialog != null && mProgressDialog!!.isShowing) {
        mProgressDialog!!.dismiss()
    }
}

fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.setInVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.INVISIBLE else View.VISIBLE
}

fun Context.showToast(msg: Any, duration: Int = Toast.LENGTH_SHORT) {
    when (msg) {
        is Int -> {
            Toast.makeText(this, getString(msg), Toast.LENGTH_LONG).show()
        }

        is String -> {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }
}

