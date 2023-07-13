package com.example.ddaatapp.activity

import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

open class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    protected fun showProgressDialog(message: String = "Loading...") {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog?.setMessage(message)
            progressDialog?.isIndeterminate = true
        }
        progressDialog?.show()
    }

    protected fun hideProgressDialog() {
        progressDialog?.dismiss()
        progressDialog = null
    }

    override fun onStop() {
        super.onStop()
        hideProgressDialog()
    }
}
