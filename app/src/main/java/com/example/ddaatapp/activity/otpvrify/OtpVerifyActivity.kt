package com.example.ddaatapp.activity.otpvrify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.activity.forgot.ChangePwdActivity
import com.example.ddaatapp.databinding.ActivityOtpVerifyBinding
import com.example.ddaatapp.activity.signup.CompleteProfile

class OtpVerifyActivity : AppCompatActivity(){
    private lateinit var binding: ActivityOtpVerifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operationFlow = intent.getStringExtra("operation")

        binding.btnVerify.setOnClickListener{

            if(operationFlow == "NEW_USER"){
                val intent= Intent(this, CompleteProfile::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent= Intent(this, ChangePwdActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}