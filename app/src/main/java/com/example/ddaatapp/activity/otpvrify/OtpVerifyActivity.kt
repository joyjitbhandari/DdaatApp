package com.example.ddaatapp.activity.otpvrify

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.activity.forgot.ChangePwdActivity
import com.example.ddaatapp.activity.signup.CompleteProfile
import com.example.ddaatapp.commonClass.OtpTextWatcher
import com.example.ddaatapp.databinding.ActivityOtpVerifyBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.`object`.Constants.FORGOT
import com.example.ddaatapp.`object`.Constants.SIGN_UP
import com.example.ddaatapp.requestDatamodel.OtpVerifyRequest
import com.example.ddaatapp.requestDatamodel.ResendOtpRequest
import com.example.ddaatapp.viewModel.UserViewModel

class OtpVerifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpVerifyBinding
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val operationFlow = intent.getStringExtra("operation")

        val name = intent.getStringExtra("name").toString()
        val id = intent.getStringExtra("id").toString()
        val pwd = intent.getStringExtra("pwd").toString()
        val cnfPwd = intent.getStringExtra("cnfPwd").toString()
        val email = intent.getStringExtra("email").toString()
        val type = intent.getStringExtra("type").toString()
        val mobile = intent.getStringExtra("mobile").toString()


        // Retrieve references to the OTP input fields
        val otpInput1: EditText = binding.otpInputOne
        val otpInput2: EditText = binding.otpInputTwo
        val otpInput3: EditText = binding.otpInputThree
        val otpInput4: EditText = binding.otpInputFour


        // Set up TextWatcher for each OTP input field
        otpInput1.addTextChangedListener(OtpTextWatcher(otpInput1, otpInput2))
        otpInput2.addTextChangedListener(OtpTextWatcher(otpInput2, otpInput3))
        otpInput3.addTextChangedListener(OtpTextWatcher(otpInput3, otpInput4))
        otpInput4.addTextChangedListener(OtpTextWatcher(otpInput4, null))

        //viewModel initialization
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.btnVerify.setOnClickListener {
            if (otpInput1.text.toString().isNotEmpty() && otpInput2.text.toString()
                    .isNotEmpty() && otpInput3.text.toString()
                    .isNotEmpty() && otpInput4.text.toString().isNotEmpty()
            ) {
                when (operationFlow) {
                    SIGN_UP -> {
                        val otpCode =
                            binding.otpInputOne.text.toString() + binding.otpInputTwo.text.toString() + binding.otpInputThree.text.toString() + binding.otpInputFour.text.toString()
                        Log.d("otpCode", "$otpCode")

                        viewModel.otpVerify(
                            OtpVerifyRequest(
                                name, id, pwd, cnfPwd, otpCode, email, type, mobile
                            )
                        )

                        otpResponse()

                    }
                    FORGOT -> {
                        val operationFlow = Constants.FORGOT
                        val intent = Intent(this, ChangePwdActivity::class.java)
                        intent.putExtra("operation", operationFlow)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }




        //resend button
        binding.btnResend.setOnClickListener {
            viewModel.resendOtp(ResendOtpRequest(id))
            resendResponse()
        }

        //back button
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun otpResponse() {
        viewModel.otpData.observe(this, Observer { otpData ->
            // Process the response data here

            val success = otpData?.success
            val message = otpData?.message
            val token = otpData?.OTPData?.token
            Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()

            if(success == true){
                val operationFlow = SIGN_UP
                val intent = Intent(this, CompleteProfile::class.java)
                intent.putExtra("operation", operationFlow)
                startActivity(intent)
                finish()
            }
        })
    }

    private fun resendResponse() {
        viewModel.resendOtpData.observe(this, Observer { resendOtpData ->
            // Process the response data here

            val success = resendOtpData?.success
            val message = resendOtpData?.message
            Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
        })
    }

}