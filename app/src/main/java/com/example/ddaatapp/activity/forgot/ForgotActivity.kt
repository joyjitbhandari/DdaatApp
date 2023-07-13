package com.example.ddaatapp.activity.forgot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.databinding.ActivityForgotBinding
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.utils.hideProgressDialog
import com.example.ddaatapp.utils.showProgressDialog
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.utils.validateEmail
import com.example.ddaatapp.viewModel.PasswordViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class ForgotActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityForgotBinding
    private lateinit var viewModel : PasswordViewModel //declaration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize
        viewModel = ViewModelProvider(this,ViewModelFactory(RetrofitClient().apiService))[PasswordViewModel::class.java]

        initObserver()
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnSetNewPwd -> {
                val email = binding.etEmail.text.toString()
                if (email.isNotEmpty()) {
                    if (validateEmail(email)) {
                showProgressDialog(this)
                        viewModel.forgotPwd(email)

                    } else {
                        binding.etEmail.error = "Invalid email format"
                    }
                } else {
                    binding.etEmail.error = "This field is required"
                }
            }
            binding.btnBack -> onBackPressed()
        }
    }



    private fun initObserver() {
        viewModel.forgotPwdData.observe(this) {
            hideProgressDialog()
            if (it?.success == true) {
                val intent = Intent(this, OtpVerifyActivity::class.java).apply {
                    putExtra("operation", Constants.FORGOT)
                    putExtra("forgotEmail", binding.etEmail.text.toString()) }
                startActivity(intent)
            }else{
                showToast(it?.message.toString())
            }
        }
        viewModel.toastMsg.observe(this,EventObserver{
            hideProgressDialog()
            showToast(it,Toast.LENGTH_SHORT)
        })
    }

}