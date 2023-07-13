package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.databinding.ActivitySignUpBinding
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.Constants.SIGN_UP
import com.example.ddaatapp.utils.*
import com.example.ddaatapp.viewModel.SignUPViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class SignUpActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUPViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitClient().apiService)
        )[SignUPViewModel::class.java]

        initObserver()

    }


    override fun onClick(view: View?) {
        when (view) {

            binding.signupBtn -> {
                if (doValidations()) {
                    showProgressDialog()
                    if (validateEmail(binding.etEmailMobile.text.toString())) {
                        viewModel.signUp(
                            com.example.ddaatapp.model.requestDatamodel.SignUpRequest(
                                binding.etName.text.toString(),
                                binding.etUserId.text.toString(),
                                binding.etPwd.text.toString(),
                                binding.etCnfPwd.text.toString(),
                                binding.etEmailMobile.text.toString(),
                                "email",
                                ""
                            )
                        )
                    } else if (validateMobile(binding.etEmailMobile.text.toString())) {
                        viewModel.signUp(
                            com.example.ddaatapp.model.requestDatamodel.SignUpRequest(
                                binding.etName.text.toString(),
                                binding.etUserId.text.toString(),
                                binding.etPwd.text.toString(),
                                binding.etCnfPwd.text.toString(),
                                "",
                                "mobile",
                                binding.etEmailMobile.text.toString()
                            )
                        )
                    } else {
                        Toast.makeText(this, "Enter valid Email or mobile number", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }


    private fun initObserver() {
        viewModel.signUpData.observe(this, Observer {
            if(it.success){
                hideProgressDialog()
                if(validateEmail(binding.etEmailMobile.text.toString())){
                    val intent = Intent(this, OtpVerifyActivity::class.java)
                    intent.putExtra("operation", SIGN_UP)
                    intent.putExtra("name", binding.etName.text.toString())
                    intent.putExtra("id", binding.etUserId.text.toString())
                    intent.putExtra("pwd", binding.etPwd.text.toString())
                    intent.putExtra("cnfPwd", binding.etCnfPwd.text.toString())
                    intent.putExtra("email", binding.etEmailMobile.text.toString())
                    intent.putExtra("type", "email")
                    intent.putExtra("mobile", "")
                    startActivity(intent)
                }else {
                    val intent = Intent(this, OtpVerifyActivity::class.java)
                    intent.putExtra("operation", SIGN_UP)
                    intent.putExtra("name", binding.etName.text.toString())
                    intent.putExtra("id", binding.etUserId.text.toString())
                    intent.putExtra("pwd", binding.etPwd.text.toString())
                    intent.putExtra("cnfPwd", binding.etCnfPwd.text.toString())
                    intent.putExtra("email", "")
                    intent.putExtra("type", "mobile")
                    intent.putExtra("mobile", binding.etEmailMobile.text.toString())
                    startActivity(intent)
                }
                showToast(it.message, Toast.LENGTH_SHORT)
            }else{
                hideProgressDialog()
                showToast(it.message, Toast.LENGTH_SHORT)
            }

        })

        viewModel.toastMsg.observe(this, EventObserver{
            hideProgressDialog()
            showToast(it,Toast.LENGTH_SHORT)
        })
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