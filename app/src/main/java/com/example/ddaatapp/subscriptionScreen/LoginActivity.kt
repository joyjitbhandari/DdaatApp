package com.example.ddaatapp.subscriptionScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.forgot.ForgotActivity
import com.example.ddaatapp.databinding.ActivityLoginBinding
import com.example.ddaatapp.activity.signup.SignUpActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.emailMobCheckbox.setOnCheckedChangeListener { button, isChecked ->

            if(isChecked){
                binding.txtUserId.setText(R.string.email_address_mobile)
                binding.etUserId.visibility = View.GONE
                binding.etEmailMob.visibility = View.VISIBLE
            }else{
                binding.txtUserId.setText(R.string.user_id)
                binding.etUserId.visibility = View.VISIBLE
                binding.etEmailMob.visibility = View.GONE
            }
        }
    }

    override fun onClick(view: View?) {
        when(view){
            binding.txtForgotPassword->{
                val forgotPwd = Intent(this, ForgotActivity::class.java)
                startActivity(forgotPwd)
            }
            binding.txtDontHaveAcc->{
                val signUp = Intent(this, SignUpActivity::class.java)
                startActivity(signUp)
            }

            binding.loginBtn->{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}