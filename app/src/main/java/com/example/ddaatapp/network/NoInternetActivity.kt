package com.example.ddaatapp.network

import android.os.Bundle
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.databinding.ActivityNoInternetBinding
import com.example.ddaatapp.utils.Constants

class NoInternetActivity : BaseActivity() {
    private lateinit var binding : ActivityNoInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRetry.setOnClickListener{
            if (isInternetConnected(this)) {
                // If there is internet connectivity, finish this activity and return to the previous one.
                Constants.shouldCheckConnectivity = true
                finish()
            } else {
                // If there is still no internet connectivity, refresh the current activity.
                val intent = intent
                finish()
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Constants.shouldCheckConnectivity = true
    }
}