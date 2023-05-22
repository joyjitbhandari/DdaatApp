package com.example.ddaatapp.activity.otpvrify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.activity.forgot.ChangePwdActivity
import com.example.ddaatapp.databinding.ActivityOtpVerifyBinding
import com.example.ddaatapp.activity.signup.CompleteProfile
import com.example.ddaatapp.`object`.Constants

class OtpVerifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpVerifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operationFlow = intent.getStringExtra("operation")

        binding.btnVerify.setOnClickListener {
            when (operationFlow) {
                Constants.SIGN_UP-> {
                    val operationFlow = Constants.SIGN_UP
                    val intent = Intent(this, CompleteProfile::class.java)
                    intent.putExtra("operation",operationFlow)
                    startActivity(intent)
                    finish()
                }
                Constants.FORGOT-> {
                    val operationFlow = Constants.FORGOT
                    val intent = Intent(this, ChangePwdActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    startActivity(intent)
                    finish()
                }
            }
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}