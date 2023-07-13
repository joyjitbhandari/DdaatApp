package com.example.ddaatapp.activity.splash

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.login.LoginActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.ActivityOnBoardingBinding
import com.flynaut.healthtag.util.PrefsManager
import com.flynaut.healthtag.util.PrefsManager.Companion.IS_ONBOARDING_COMPLETED

class OnBoardingActivity : AppCompatActivity(), View.OnClickListener {
    private var count = 0
    private lateinit var binding:ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        PrefsManager.initialize(this)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val onBoardingFinished = PrefsManager.get().getBoolean(IS_ONBOARDING_COMPLETED, false)
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
                finishBoarding()
            }

            binding.btnNext->{
                count++
                when(count){
                    1->{
                        binding.onboardingImage.setImageResource(R.drawable.onboarding_img_2)
                        binding.progress.setProgress(66,true)
                    }
                    2->{
                        binding.btnSkip.visibility = View.GONE
                        binding.onboardingImage.setImageResource(R.drawable.onboarding_img_3)
                        binding.progress.setProgress(100,true)
                    }
                    3->{
                        finishBoarding()
                    }
                }
            }
        }
    }
    private fun finishBoarding() {
        PrefsManager(this).save(IS_ONBOARDING_COMPLETED,true)

        // Proceed to the Login screen
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}

