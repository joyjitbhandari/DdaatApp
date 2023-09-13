package com.example.ddaatapp.activity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.forgot.ForgotActivity
import com.example.ddaatapp.activity.signup.SignUpActivity
import com.example.ddaatapp.databinding.ActivityLoginBinding
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.subscriptionScreen.HomeActivity
import com.example.ddaatapp.unsubscribeScreen.UnsubscribeHomeActivity
import com.example.ddaatapp.utils.*
import com.example.ddaatapp.utils.SavedData.profileData
import com.example.ddaatapp.viewModel.LogInViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver
import com.flynaut.healthtag.util.PrefsManager
import com.flynaut.healthtag.util.PrefsManager.Companion.IS_LOG_IN
import com.google.gson.Gson

class LoginActivity : BaseActivity(), View.OnClickListener {


    private lateinit var viewModel: LogInViewModel
    private var isEmailMobile = false
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewModel initialization
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitClient().apiService)
        )[LogInViewModel::class.java]

        initObserver()
        val isLogIn = PrefsManager.get().getBoolean(IS_LOG_IN, false)

        //if log in go to Home
        if (isLogIn) {
            if (profileData?.subscription_id.isNullOrEmpty()) {
                startActivity(Intent(this, UnsubscribeHomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, HomeActivity::class.java))
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
                    val email = binding.etEmailMob
                    val userId = binding.etUserId
                    val password = binding.etPwd

                    if (!isEmailMobile) {
                        if (doValidations(userId, password)) {
                            //user id
                            showProgressDialog()
                            viewModel.login(
                                com.example.ddaatapp.model.requestDatamodel.LoginRequest(
                                    userId.text.toString(),
                                    password.text.toString(),
                                    "userid",
                                    null,
                                    null
                                )
                            )
                        }

                    } else {
                        if (doValidations(email, password)) {
                            if (validateEmail(email.text.toString())) {
                                //email
                                showProgressDialog()
                                viewModel.login(
                                    com.example.ddaatapp.model.requestDatamodel.LoginRequest(
                                        null,
                                        password.text.toString(),
                                        "email",
                                        null,
                                        email.text.toString()
                                    )
                                )
                            } else if (validateMobile(email.text.toString())) {
                                //mobile
                                showProgressDialog()
                                viewModel.login(
                                    com.example.ddaatapp.model.requestDatamodel.LoginRequest(
                                        null,
                                        password.text.toString(),
                                        "mobile",
                                        email.text.toString(),
                                        null
                                    )
                                )
                            }else{
                                showToast("Above credentials are not correct ")
                            }
                        }
                    }
            }
        }
    }

    private fun doValidations(userName: TextView, password: TextView): Boolean {

        return if (userName.text.toString().isEmpty()) {
            userName.error = "This Field is required"
            false
        } else if (password.text.toString().isEmpty()) {
            password.error = "This Field is required"
            false
        } else true
    }

    private fun initObserver() {
        viewModel.apiResponse.observe(this, Observer {
            hideProgressDialog()
            if(it?.success==true){
                val prefsManager = PrefsManager.get()
                prefsManager.save(PrefsManager.PREF_API_TOKEN, it.data?.token.toString())
                Log.d("token", "initObserver: ${it.data?.token.toString()}")
//                profileData = it.data!!
                PrefsManager.get().save(
                    PrefsManager.PREF_PROFILE,
                    Gson().toJson(it.data)
                )
                prefsManager.save(IS_LOG_IN, true)
                openActivity(it.data?.subscription_id.toString())
                showToast(it.message, Toast.LENGTH_SHORT)
            }else{
                showToast(it.message, Toast.LENGTH_SHORT)
            }
        })

        viewModel.toastMsg.observe(this, EventObserver {
            hideProgressDialog()
            showToast(it, Toast.LENGTH_SHORT)
        })
    }

    private fun openActivity(subsId: String) {
        val intent = if (subsId.isNullOrEmpty())
            Intent(this, UnsubscribeHomeActivity::class.java)
        else
            Intent(this, HomeActivity::class.java)

        startActivity(intent)
        finish()
    }


}