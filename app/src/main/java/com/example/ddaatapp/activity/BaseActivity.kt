package com.example.ddaatapp.activity

import android.app.ProgressDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ddaatapp.R
import com.example.ddaatapp.network.NoInternetActivity
import com.example.ddaatapp.utils.Utils.shouldCheckConnectivity

open class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null


    private val networkChangeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (shouldCheckConnectivity && !context?.let { isInternetConnected(it) }!!) {
                shouldCheckConnectivity = false
                showNoInternetDialog(context)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        // Register the BroadcastReceiver to listen for network state changes when the activity is resumed.
        registerNetworkChangeReceiver()
    }

    override fun onPause() {
        super.onPause()
        // Unregister the BroadcastReceiver when the activity is paused to avoid memory leaks.
        unregisterNetworkChangeReceiver()
    }
    protected fun isInternetConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }

    protected fun showNoInternetDialog(context: Context) {
        startActivity(Intent(context, NoInternetActivity::class.java))
        overridePendingTransition(R.anim.pop_up_from_center, R.anim.no_animation)

        // Alternatively, you can show an AlertDialog as you commented out.
        // AlertDialog.Builder(context)
        //     .setTitle("No Internet Connection")
        //     .setMessage("Please turn on your data or connect to a Wi-Fi network.")
        //     .setPositiveButton("OK") { _, _ -> }
        //     .show()
    }

    private fun registerNetworkChangeReceiver() {
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
    }

    private fun unregisterNetworkChangeReceiver() {
        unregisterReceiver(networkChangeReceiver)
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
    protected fun customLayoutManagerWithOutScrolling(): LinearLayoutManager {
        val customLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        return customLayoutManager
    }

    override fun onStop() {
        super.onStop()
        hideProgressDialog()
    }
}
