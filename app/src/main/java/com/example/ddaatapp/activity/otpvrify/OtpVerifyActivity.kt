package com.example.ddaatapp.activity.otpvrify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.forgot.ChangePwdActivity
import com.example.ddaatapp.activity.signup.CompleteProfile
import com.example.ddaatapp.databinding.ActivityOtpVerifyBinding
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.network.TokenManager
import com.example.ddaatapp.utils.Constants.FORGOT
import com.example.ddaatapp.utils.Constants.SIGN_UP
import com.example.ddaatapp.utils.*
import com.example.ddaatapp.viewModel.OTPViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver
import com.flynaut.healthtag.util.PrefsManager
import com.flynaut.healthtag.util.PrefsManager.Companion.PREF_API_TOKEN

class OtpVerifyActivity : BaseActivity() {
    private lateinit var binding: ActivityOtpVerifyBinding
    private lateinit var viewModel: OTPViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel initialization
        viewModel = ViewModelProvider(this, ViewModelFactory(RetrofitClient().apiService))[OTPViewModel::class.java]
        initObserver()

        val operationFlow = intent.getStringExtra("operation")

        val name = intent.getStringExtra("name").toString()
        val id = intent.getStringExtra("id").toString()
        val pwd = intent.getStringExtra("pwd").toString()
        val cnfPwd = intent.getStringExtra("cnfPwd").toString()
        val email = intent.getStringExtra("email").toString()
        val type = intent.getStringExtra("type").toString()
        val mobile = intent.getStringExtra("mobile").toString()

        //forgot  mail
        val  forgotPwdEmail = intent.getStringExtra("forgotEmail").toString()


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


        binding.btnVerify.setOnClickListener {

            if (otpInput1.text.toString().isNotEmpty() && otpInput2.text.toString()
                    .isNotEmpty() && otpInput3.text.toString()
                    .isNotEmpty() && otpInput4.text.toString().isNotEmpty()
            ) {
                val otpCode =
                    binding.otpInputOne.text.toString() + binding.otpInputTwo.text.toString() + binding.otpInputThree.text.toString() + binding.otpInputFour.text.toString()
                when (operationFlow) {
                    SIGN_UP -> {
                        Log.d("otpCode", "$otpCode")
                        showProgressDialog()
                        viewModel.otpVerify(
                            com.example.ddaatapp.model.requestDatamodel.OtpVerifyRequest(
                                name,
                                id,
                                pwd,
                                cnfPwd,
                                otpCode,
                                email,
                                type,
                                mobile
                            )
                        )

                    }
                    FORGOT -> {
                        Log.d("otpCode", "$otpCode")
                        showProgressDialog()
                        viewModel.forgotPwdVerify(
                            com.example.ddaatapp.model.requestDatamodel.ForgotPwdOtpRequest(
                                forgotPwdEmail,
                                otpCode
                            )
                        )

                    }
                }
            }
        }


        //resend button
        binding.btnResend.setOnClickListener {
            showProgressDialog()
            val fields = HashMap<String, String>()
            if(operationFlow == SIGN_UP)
                fields["user_id"] = id
            else
                fields["user_id"] = forgotPwdEmail

            viewModel.resendOtp(fields)
        }

        //back button
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initObserver() {
        viewModel.otpData.observe(this, Observer {
            hideProgressDialog()
            if(it?.success == true){
                PrefsManager.get().save(PREF_API_TOKEN, it.data.token.toString())
                val intent = Intent(this, CompleteProfile::class.java)
                intent.putExtra("operation", SIGN_UP)
                startActivity(intent)
                finish()
            }else
                showToast(it?.message.toString(), Toast.LENGTH_SHORT)
        })

        viewModel.forgotPwdOtpData.observe(this, Observer {
            hideProgressDialog()
            if(it?.success == true) {
                val intent = Intent(this, ChangePwdActivity::class.java)
                intent.putExtra("operation", FORGOT)
                startActivity(intent)
                finish()
            }else
                showToast(it?.message.toString(),Toast.LENGTH_SHORT)

        })

        viewModel.resendOtpData.observe(this, Observer {
            hideProgressDialog()
            showToast(it?.message.toString(),Toast.LENGTH_SHORT)
        })

        viewModel.toastMsg.observe(this, EventObserver {
            hideProgressDialog()
            showToast( it, Toast.LENGTH_SHORT)
        })
    }

}