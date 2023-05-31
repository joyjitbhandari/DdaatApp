package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.commonClass.validateConfPass
import com.example.ddaatapp.commonClass.validateEmail
import com.example.ddaatapp.commonClass.validateMobile
import com.example.ddaatapp.commonClass.validatePassword
import com.example.ddaatapp.databinding.ActivitySignUpBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.viewModel.UserViewModel

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: UserViewModel

    private var message: String = "Error Occurred"
    private var success: String = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        //data from api
        viewModel.signUpData.observe(this, Observer { signUpData ->
            // Process the response data here
            success = signUpData?.success.toString()
            message = signUpData?.message.toString()
            Log.d("get", "$success, $message")
        })
    }


    override fun onClick(view: View?) {
        when (view) {

            binding.signupBtn -> {
                val operationFlow = Constants.SIGN_UP

                if (doValidations()) {
                    if (validateEmail(binding.etEmailMobile.text.toString())) {
                        viewModel.signUp(
                            com.example.ddaatapp.requestDatamodel.SignUpRequest(
                                binding.etName.text.toString(),
                                binding.etUserId.text.toString(),
                                binding.etPwd.text.toString(),
                                binding.etCnfPwd.text.toString(),
                                binding.etEmailMobile.text.toString(),
                                "email",
                                ""
                            )
                        )
                        if (success == "true") {
                            val intent = Intent(this, OtpVerifyActivity::class.java)
                            intent.putExtra("operation", operationFlow)
                            intent.putExtra("name", binding.etName.text.toString())
                            intent.putExtra("id", binding.etUserId.text.toString())
                            intent.putExtra("pwd", binding.etPwd.text.toString())
                            intent.putExtra("cnfPwd", binding.etCnfPwd.text.toString())
                            intent.putExtra("email", binding.etEmailMobile.text.toString())
                            intent.putExtra("type", "email")
                            intent.putExtra("mobile", "")
                            startActivity(intent)
                            Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                        }

                    } else if (validateMobile(binding.etEmailMobile.text.toString())) {
                        viewModel.signUp(
                            com.example.ddaatapp.requestDatamodel.SignUpRequest(
                                binding.etName.text.toString(),
                                binding.etUserId.text.toString(),
                                binding.etPwd.text.toString(),
                                binding.etCnfPwd.text.toString(),
                                "",
                                "mobile",
                                binding.etEmailMobile.text.toString(),
                            )
                        )
                        if (success == "true") {
                            val intent = Intent(this, OtpVerifyActivity::class.java)
                            intent.putExtra("operation", operationFlow)
                            intent.putExtra("name", binding.etName.text.toString())
                            intent.putExtra("id", binding.etUserId.text.toString())
                            intent.putExtra("pwd", binding.etPwd.text.toString())
                            intent.putExtra("cnfPwd", binding.etCnfPwd.text.toString())
                            intent.putExtra("email", "")
                            intent.putExtra("type", "mobile")
                            intent.putExtra("mobile", binding.etEmailMobile.text.toString())
                            startActivity(intent)
                            Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

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
                            .isNotEmpty() && validatePassword(binding.etPwd.text.toString())
                    ) {
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
                        /* if (binding.etPwd.text.toString()==(".*[0-9].*")) {
                             binding.etPwd.error = "Password should contain at least 1 digit"
                         }
                         else if (binding.etPwd.text.toString()==(".*[a-z].*")) {
                             binding.etPwd.error = "Password should contain at least 1 lower case letter"
                         }
                         else if (binding.etPwd.text.toString()==(".*[A-Z].*")) {
                             binding.etPwd.error = "Password should contain at least 1 upper case letter"
                         }
                         else if (binding.etPwd.text.toString()==(".*[a-zA-Z].*")) {
                             binding.etPwd.error = "Password should contain a letter"
                         }
                         else if (binding.etPwd.text.toString()==( ".{8,}")) {
                             binding.etPwd.error = "Password should contain 8 characters"
                         }
                         else {
                             return true;
                         }*/
                        binding.etPwd.error = "password error"
                        false
                    }
                } else {
                    binding.etEmailMobile.error = "Please enter valid Email or mobile."
                    false
                }
            } else {
                binding.etUserId.error = "This filed is required"
                false

            }
        } else {
            binding.etName.error = "This filed is required"
            false
        }
    }
}