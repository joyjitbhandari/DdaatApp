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

    lateinit var sharedPref: SharedPreferences
    private lateinit var binding: ActivityLoginBinding



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
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, UnsubscribeHomeActivity::class.java)
                startActivity(intent)
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
            binding.txtForgotPassword -> {
                val forgotPwd = Intent(this, ForgotActivity::class.java)
                startActivity(forgotPwd)
            }
            binding.txtDontHaveAcc -> {
                val signUp = Intent(this, SignUpActivity::class.java)
                startActivity(signUp)
            }

            binding.loginBtn -> {
                //if userId
                if(doValidations(isEmailMobile) == true){
                    viewModel.login(LoginRequest(
                        binding.etUserId.text.toString(),
                        binding.etPwd.text.toString(),
                        "userid",
                        "",
                        ""
                    ))
                    loginOperation()
                }else if(doValidations(isEmailMobile) == false){
                    if (validateEmail(binding.etEmailMob.text.toString())){
                        viewModel.login(LoginRequest(
                            "",
                            binding.etPwd.text.toString(),
                            "email",
                            "",
                            binding.etEmailMob.text.toString()
                        )
                        )
                        loginOperation()
                    }else if(validateMobile(binding.etEmailMob.text.toString())){
                        viewModel.login(LoginRequest(
                            "",
                            binding.etPwd.text.toString(),
                            "mobile",
                            binding.etEmailMob.text.toString(),
                            ""
                        )
                        )
                        loginOperation()
                    }else{

                    }

                }else{

                }

            }
        }
    }

    private fun loginOperation(){
        viewModel.loginData.observe(this, Observer { loginData ->
            // Process the response data here

            val success = loginData?.success
            val message = loginData?.message
            val subsId = loginData?.data?.subscription_id

            openActivity(subsId.toString())
            Log.d("get", "$success, $message, $subsId")
        })

    }
    private fun doValidations(isEmailMobile : Boolean ): Boolean {
        var isUserID = false

        if (isEmailMobile) {
            if (binding.etEmailMob.text.toString().isNotEmpty() && binding.etPwd.text.toString()
                    .isNotEmpty()
            ) {
                isUserID = false
            }else{
                binding.etEmailMob.error = "This Filed Is Required"
                binding.etPwd.error = "This Filed Is Required"
            }
        } else {
            if (binding.etUserId.text.toString().isNotEmpty() && binding.etPwd.text.toString()
                    .isNotEmpty()
            ) {
                isUserID = true
            }else{
                binding.etUserId.error = "This Filed Is Required"
                binding.etPwd.error = "This Filed Is Required"
            }
        }

        return isUserID
    }



    private fun openActivity(subsId:String) {
        val editor = sharedPref.edit()
        if (subsId == "null") {
            editor.putBoolean("isLoggedIn", true)
            editor.putBoolean("isSubscribed", false)
            editor.apply()
            val intent = Intent(this, UnsubscribeHomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            editor.putBoolean("isLoggedIn", true)
            editor.putBoolean("isSubscribed", true)
            editor.apply()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}