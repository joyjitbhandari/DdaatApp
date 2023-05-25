package com.example.ddaatapp.activity.otpvrify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ddaatapp.activity.forgot.ChangePwdActivity
import com.example.ddaatapp.databinding.ActivityOtpVerifyBinding
import com.example.ddaatapp.activity.signup.CompleteProfile
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.`object`.Constants.FORGOT
import com.example.ddaatapp.`object`.Constants.SIGN_UP
import com.example.ddaatapp.postDatamodel.PostOtpVerify
import com.example.ddaatapp.responseDatamodel.ResponseOtpVerify
import com.example.ddaatapp.responseDatamodel.ResponseUserSignUp
import com.example.ddaatapp.retrofit.RetrofitInstance
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class OtpVerifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpVerifyBinding
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



        binding.btnVerify.setOnClickListener {
            when (operationFlow) {
                SIGN_UP-> {
                    val otpCode = binding.otpInputOne.text.toString()+ binding.otpInputTwo.text.toString()+binding.otpInputThree.text.toString()+ binding.otpInputFour.text.toString()
                    Log.d("otpCode", "$otpCode")

                    postOtpVerify(
                        PostOtpVerify(
                            name,id,pwd,cnfPwd,otpCode,email,type,mobile
                        )
                    )
                        val operationFlow = SIGN_UP
                        val intent = Intent(this, CompleteProfile::class.java)
                        intent.putExtra("operation",operationFlow)
                        startActivity(intent)
                        finish()

                }
                FORGOT-> {
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

    private fun postOtpVerify(otpVerify: PostOtpVerify) {
        val call = RetrofitInstance.apiServices.otpVerify(otpVerify)
        call.enqueue(object : Callback<ResponseOtpVerify> {
            override fun onResponse(
                call: Call<ResponseOtpVerify>,
                response: Response<ResponseOtpVerify>,

            ) {
                Log.d("get", "${response.body()}, ${response.code()}")
            }

            override fun onFailure(call: Call<ResponseOtpVerify>, t: Throwable) {
                Toast.makeText(this@OtpVerifyActivity, "Error Occurred", Toast.LENGTH_SHORT).show()
            }

        })

    }
}