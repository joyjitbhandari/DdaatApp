package com.example.ddaatapp.activity.forgot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.databinding.ActivityForgotBinding

class ForgotActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityForgotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
       when(view){
           binding.btnSetNewPwd->{
               val operationFlow = "FORGOT"
               val intent = Intent(this, OtpVerifyActivity::class.java)
               intent.putExtra("operation",operationFlow)
               startActivity(intent)
           }
       }
    }

}