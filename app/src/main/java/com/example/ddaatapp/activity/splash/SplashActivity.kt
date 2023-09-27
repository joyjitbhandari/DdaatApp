package com.example.ddaatapp.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.ActivitySplashBinding
import com.example.ddaatapp.subscriptionScreen.HomeActivity
import com.example.ddaatapp.unsubscribeScreen.UnsubscribeHomeActivity
import com.example.ddaatapp.utils.SavedData.profileData
import com.flynaut.healthtag.util.PrefsManager

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIMEOUT_TIME = 10000 //10 sec

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        PrefsManager.initialize(this)

        Glide.with(this).load(R.drawable.splash).into(binding.imgLogo)

        val isLogIn = PrefsManager(this).getBoolean(PrefsManager.IS_LOG_IN, false)

        //for time delay
        Handler().postDelayed({
            if (!isLogIn) {
                val onboard = Intent(this, OnBoardingActivity::class.java)
                startActivity(onboard)
            } else {
                if (profileData?.subscription_id.isNullOrEmpty())
                    startActivity(Intent(this, UnsubscribeHomeActivity::class.java))
                else
                    startActivity(Intent(this, HomeActivity::class.java))
            }
            finish()
        }, SPLASH_TIMEOUT_TIME.toLong())
    }
}