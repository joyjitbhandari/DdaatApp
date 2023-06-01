package com.example.ddaatapp.activity.login

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
import com.example.ddaatapp.activity.forgot.ForgotActivity
import com.example.ddaatapp.activity.signup.SignUpActivity
import com.example.ddaatapp.commonClass.validateEmail
import com.example.ddaatapp.commonClass.validateMobile
import com.example.ddaatapp.databinding.ActivityLoginBinding
import com.example.ddaatapp.requestDatamodel.LoginRequest
import com.example.ddaatapp.subscriptionScreen.HomeActivity
import com.example.ddaatapp.unsubscribeScreen.UnsubscribeHomeActivity
import com.example.ddaatapp.viewModel.UserViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var viewModel: UserViewModel
    private var isEmailMobile = false
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel initialization
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        //Checking is logged in or not
        sharedPref = getSharedPreferences(getString(R.string.Preference_file), MODE_PRIVATE)

        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
        val isSubscribed = sharedPref.getBoolean("isSubscribed", false)

        //if log in go to Home
        if (isLoggedIn) {
            if (isSubscribed) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, UnsubscribeHomeActivity::class.java))
                finish()
            }

        }

        binding.emailMobCheckbox.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                isEmailMobile = true
                binding.txtUserId.setText(R.string.email_address_mobile)
                binding.etUserId.visibility = View.GONE
                binding.etEmailMob.visibility = View.VISIBLE
            } else {
                isEmailMobile = false
                binding.txtUserId.setText(R.string.user_id)
                binding.etUserId.visibility = View.VISIBLE
                binding.etEmailMob.visibility = View.GONE
            }
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.txtForgotPassword -> startActivity(Intent(this, ForgotActivity::class.java))
            binding.txtDontHaveAcc -> startActivity(Intent(this, SignUpActivity::class.java))
            binding.loginBtn -> {
                val emailMobText = binding.etEmailMob.text.toString()
                val userIdText = binding.etUserId.text.toString()
                val passwordText = binding.etPwd.text.toString()

                if (doValidations(isEmailMobile)) {
                    //user id
                    viewModel.login(LoginRequest(userIdText, passwordText, "userid", "", ""))
                    loginResponse()
                } else if (validateEmail(emailMobText)) {
                    //email
                    viewModel.login(LoginRequest("", passwordText, "email", "", emailMobText))
                    loginResponse()
                } else if (validateMobile(emailMobText)) {
                    //mobile
                    viewModel.login(LoginRequest("", passwordText, "mobile", emailMobText, ""))
                    loginResponse()
                } else {
                    Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun doValidations(isEmailMobile: Boolean): Boolean {
        val emailMobField = binding.etEmailMob
        val userIdField = binding.etUserId
        val pwdField = binding.etPwd

        val isEmailMobEmpty = emailMobField.text.toString().isEmpty()
        val isUserIdEmpty = userIdField.text.toString().isEmpty()
        val isPwdEmpty = pwdField.text.toString().isEmpty()

        emailMobField.error = if (isEmailMobile && isEmailMobEmpty) "This Field Is Required" else null
        userIdField.error = if (!isEmailMobile && isUserIdEmpty) "This Field Is Required" else null
        pwdField.error = if ((isEmailMobile && isPwdEmpty) || (!isEmailMobile && isPwdEmpty)) "This Field Is Required" else null

        return !isEmailMobile
    }

    private fun loginResponse() {
        viewModel.loginData.observe(this, Observer { loginData ->
            // Process the response data here

            val success = loginData?.success
            val message = loginData?.message
            val subsId = loginData?.data?.subscription_id

            openActivity(subsId.toString())
            Log.d("get", "$success, $message, $subsId")
        })
    }


    private fun openActivity(subsId: String) {
        val editor = sharedPref.edit()

        val intent = if (subsId == "null") {
            Intent(this, UnsubscribeHomeActivity::class.java)
        } else {
            Intent(this, HomeActivity::class.java)
        }

        startActivity(intent)
        editor.putBoolean("isLoggedIn", true)
        editor.putBoolean("isSubscribed", subsId != "null")
        editor.apply()
        finish()
    }
}