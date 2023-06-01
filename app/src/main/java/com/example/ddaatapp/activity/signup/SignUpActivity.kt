package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.commonClass.validateConfPass
import com.example.ddaatapp.commonClass.validateEmail
import com.example.ddaatapp.commonClass.validateMobile
import com.example.ddaatapp.databinding.ActivitySignUpBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.viewModel.UserViewModel

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: UserViewModel

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences(getString(R.string.Preference_file), MODE_PRIVATE)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

    }


    override fun onClick(view: View?) {
        when (view) {

            binding.signupBtn -> {
                val operationFlow = Constants.SIGN_UP

                if (doValidations()) {

//                    val editor = sharedPref.edit()
//                    editor.putString("old_pwd",binding.etPwd.text.toString())
//                    editor.apply()

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
                        //data from api
                        viewModel.signUpData.observe(this, Observer { signUpData ->
                            // Process the response data here
                            val success = signUpData?.success
                            val message = signUpData?.message.toString()
                            Log.d("get", "$success, $message")

                            if (success == true) {
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
                        })
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

                        //data from api
                        viewModel.signUpData.observe(this, Observer { signUpData ->
                            // Process the response data here
                            val success = signUpData?.success
                            val message = signUpData?.message.toString()
                            Log.d("get", "$success, $message")
                            if (success == true) {
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
                        })
                    } else {
                        Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }


    private fun doValidations(): Boolean {
        val nameText = binding.etName.text.toString()
        val userIdText = binding.etUserId.text.toString()
        val emailMobileText = binding.etEmailMobile.text.toString()
        val pwdText = binding.etPwd.text.toString()
        val cnfPwdText = binding.etCnfPwd.text.toString()


        return if (nameText.isNotEmpty()) {
            if (userIdText.isNotEmpty()) {
                if (emailMobileText.isNotEmpty() && (validateEmail(emailMobileText) || validateMobile(
                        emailMobileText
                    ))
                ) {
                    if (pwdText.isNotEmpty() /*&& validatePassword(pwdText)*/) {
                        if (cnfPwdText.isNotEmpty() && validateConfPass(pwdText, cnfPwdText)) {
                            true
                        } else {
                            binding.etCnfPwd.error = "Password did not match"
                            false
                        }
                    } else {
                        binding.etPwd.error =
                            "Invalid password, Type should be minimum 1 Uppercase, 1 special charter and length more than 8   "
                        false
                    }
                } else {
                    binding.etEmailMobile.error = "Please enter a valid Email or mobile"
                    false
                }
            } else {
                binding.etUserId.error = "This field is required"
                false
            }
        } else {
            binding.etName.error = "This field is required"
            false
        }
    }

}