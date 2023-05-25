package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.commonClass.validateConfPass
import com.example.ddaatapp.commonClass.validateEmail
import com.example.ddaatapp.commonClass.validateMobile
import com.example.ddaatapp.commonClass.validatePassword
import com.example.ddaatapp.databinding.ActivitySignUpBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.`object`.Constants.EMAIL_PATTERN
import com.example.ddaatapp.`object`.Constants.MOBILE_PATTERN
import com.example.ddaatapp.postDatamodel.PostUserSignUp
import com.example.ddaatapp.responseDatamodel.ResponseUserSignUp
import com.example.ddaatapp.retrofit.RetrofitInstance
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


    override fun onClick(view: View?) {
        when (view) {

            binding.signupBtn -> {
                val operationFlow = Constants.SIGN_UP

                if (doValidations()) {
                    if (validateEmail(binding.etEmailMobile.text.toString())) {
                        postSignUp(
                            com.example.ddaatapp.postDatamodel.PostUserSignUp(
                                binding.etName.text.toString(),
                                binding.etUserId.text.toString(),
                                binding.etPwd.text.toString(),
                                binding.etCnfPwd.text.toString(),
                                binding.etEmailMobile.text.toString(),
                                "email",
                                ""
                            )
                        )

                        val intent = Intent(this, OtpVerifyActivity::class.java)
                        intent.putExtra("operation", operationFlow)
                        intent.putExtra("name", binding.etName.text.toString())
                        intent.putExtra("id", binding.etUserId.text.toString())
                        intent.putExtra("pwd", binding.etPwd.text.toString())
                        intent.putExtra("cnfPwd", binding.etCnfPwd.text.toString())
                        intent.putExtra("email", binding.etEmailMobile.text.toString())
                        intent.putExtra("type", "email")
                        intent.putExtra("mobile","")
                        startActivity(intent)
                    } else if (validateMobile(binding.etEmailMobile.text.toString())) {
                        postSignUp(
                            com.example.ddaatapp.postDatamodel.PostUserSignUp(
                                binding.etName.text.toString(),
                                binding.etUserId.text.toString(),
                                binding.etPwd.text.toString(),
                                binding.etCnfPwd.text.toString(),
                                "",
                                "mobile",
                                binding.etEmailMobile.text.toString(),
                            )
                        )
                        val intent = Intent(this, OtpVerifyActivity::class.java)
                        intent.putExtra("operation", operationFlow)
                        intent.putExtra("name", binding.etName.text.toString())
                        intent.putExtra("id", binding.etUserId.text.toString())
                        intent.putExtra("pwd", binding.etPwd.text.toString())
                        intent.putExtra("cnfPwd", binding.etCnfPwd.text.toString())
                        intent.putExtra("email", "")
                        intent.putExtra("type", "mobile")
                        intent.putExtra("mobile",binding.etEmailMobile.text.toString())
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    private fun postSignUp(postUserSignUp: com.example.ddaatapp.postDatamodel.PostUserSignUp) {
        val call = RetrofitInstance.apiServices.userSignup(postUserSignUp)

        call.enqueue(object : Callback<com.example.ddaatapp.responseDatamodel.ResponseUserSignUp> {
            override fun onResponse(
                call: Call<com.example.ddaatapp.responseDatamodel.ResponseUserSignUp>,
                response: Response<com.example.ddaatapp.responseDatamodel.ResponseUserSignUp>,
            ) {


                Log.d("get", "${response.body()}, ${response.code()}")
            }

            override fun onFailure(call: Call<com.example.ddaatapp.responseDatamodel.ResponseUserSignUp>, t: Throwable) {
                Toast.makeText(this@SignUpActivity, "Error Occurred", Toast.LENGTH_SHORT).show()
            }

        })
    }


    private fun doValidations(): Boolean {
        /*TRUE & TRUE or FALSE = TRUE... ONLY one true
        *  FALSE & TRUE or FALSE = FALSE
        * TRUE & FALSE or FALSE = FALSE
        * TRUE & FALSE or TRUE = FALSE
        *
        * */

        return if (binding.etName.text.toString().isNotEmpty()) {
            if (binding.etUserId.text.toString().isNotEmpty()) {
                if (binding.etEmailMobile.text.toString().isNotEmpty() &&
                    (validateEmail(binding.etEmailMobile.text.toString()) || validateMobile(binding.etEmailMobile.text.toString()))
                ) {
                    if (binding.etPwd.text.toString()
                            .isNotEmpty() /*&& validatePassword(binding.etPwd.text.toString())*/) {
                        if (binding.etCnfPwd.text.toString().isNotEmpty()
                            && validateConfPass(
                                binding.etPwd.text.toString(),
                                binding.etCnfPwd.text.toString()
                            )
                        ) {
                            true
                        } else {
                            binding.etCnfPwd.error = "password did not matched"
                            false
                        }
                    } else {
                        binding.etPwd.error = "Please enter valid Email or mobile."
                        false
                    }
                } else {
                    binding.etEmailMobile.error = "Please enter valid Email or mobile."
                    false
                }
            } else {
                binding.etUserId.error = "Please enter valid Email or mobile."
                false

            }
        } else {
            binding.etName.error = "Please enter valid Email or mobile."
            false
        }
    }
}