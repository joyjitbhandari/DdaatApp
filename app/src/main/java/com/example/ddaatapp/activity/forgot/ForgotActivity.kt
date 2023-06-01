package com.example.ddaatapp.activity.forgot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.commonClass.validateEmail
import com.example.ddaatapp.databinding.ActivityForgotBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.requestDatamodel.ForgotPwdRequest
import com.example.ddaatapp.viewModel.UserViewModel

class ForgotActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityForgotBinding
    private lateinit var viewModel : UserViewModel //declaration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnSetNewPwd -> {
                val email = binding.etEmail.text.toString()
                /*if (email.isNotEmpty()) {
                    if (validateEmail(email)) {*/
                        viewModel.forgotPwd(ForgotPwdRequest(email))
                        forgotPwdRespond(email)
                   /* } else {
                        binding.etEmail.error = "Invalid email format"
                    }
                } else {
                    binding.etEmail.error = "This field is required"
                }*/
            }
            binding.btnBack -> onBackPressed()
        }
    }



    private fun forgotPwdRespond(email: String) {
        viewModel.forgotPwdData.observe(this) { forgotPwdResponse ->
            val success = forgotPwdResponse?.success
            val message = forgotPwdResponse?.message
            if (success == true) {
                val operationFlow = Constants.FORGOT
                val intent = Intent(this, OtpVerifyActivity::class.java).apply {
                    putExtra("operation", operationFlow)
                    putExtra("forgotEmail", email)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
            }

            //testing
            Log.d("get", "$message")
        }
    }

}