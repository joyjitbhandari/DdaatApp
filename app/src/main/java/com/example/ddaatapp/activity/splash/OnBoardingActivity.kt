package com.example.ddaatapp.activity.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ddaatapp.activity.login.LoginActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.ActivityOnBoardingBinding
import okhttp3.internal.addHeaderLenient

class OnBoardingActivity : AppCompatActivity(), View.OnClickListener {
    private var count = 0
    private lateinit var binding:ActivityOnBoardingBinding
    lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences(getString(R.string.Preference_file), MODE_PRIVATE)

        val onBoardingFinished = sharedPref.getBoolean("onboarding_completed",false)
        if(onBoardingFinished){
            // Proceed to the Login screen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onClick(view: View?) {
        //skip
        when(view){
            binding.btnSkip->{
                finishOnboarding()
            }

            binding.btnNext->{
                count++
                when(count){
                    1->{
                        binding.onboardingImage.setImageResource(R.drawable.onboarding_img_2)
                        binding.progress.setProgress(66,true)
                    }
                    2->{
                        binding.onboardingImage.setImageResource(R.drawable.onboarding_img_3)
                        binding.progress.setProgress(100,true)
                    }
                    3->{
                        finishOnboarding()
                    }
                }
            }
        }
    }
    private fun finishOnboarding() {
        val editor = sharedPref.edit()
        editor.putBoolean("onboarding_completed", true)
        editor.apply()

        // Proceed to the Login screen
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}

