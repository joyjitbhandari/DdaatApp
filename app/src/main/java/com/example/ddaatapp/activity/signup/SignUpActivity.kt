package com.example.ddaatapp.activity.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.signupBtn->{
                val operationFlow = "NEW_USER"
                val intent = Intent(this, OtpVerifyActivity::class.java)
                intent.putExtra("operation",operationFlow)
                startActivity(intent)
            }
        }

    }

}