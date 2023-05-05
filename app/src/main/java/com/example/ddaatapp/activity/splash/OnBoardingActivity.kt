package com.example.ddaatapp.activity.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.login.LoginActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity(), View.OnClickListener {
    private var count = 0
    private lateinit var binding:ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onClick(view: View?) {
        //skip
        when(view){
            binding.btnSkip->{
                val login = Intent(this, LoginActivity::class.java)
                startActivity(login)
                finish()
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
                        val login = Intent(this, LoginActivity::class.java)
                        startActivity(login)
                        finish()
                    }
                }
            }
        }
    }
}

