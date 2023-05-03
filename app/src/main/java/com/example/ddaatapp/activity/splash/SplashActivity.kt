package com.example.ddaatapp.activity.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIMEOUT_TIME = 10000 //10 sec

    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.splash).into(binding.imgLogo)

        //for time delay
        Handler().postDelayed({
            val onboard = Intent(this, OnBoardingActivity::class.java)
            startActivity(onboard)
            finish()
        }, SPLASH_TIMEOUT_TIME.toLong())
    }
}