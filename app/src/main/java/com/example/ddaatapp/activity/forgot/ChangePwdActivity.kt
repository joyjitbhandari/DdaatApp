package com.example.ddaatapp.activity.forgot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.login.LoginActivity
import com.example.ddaatapp.databinding.ActivityChangePwdBinding
import com.example.ddaatapp.`object`.Constants

class ChangePwdActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityChangePwdBinding
    private lateinit var operationFlow: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePwdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()
        if(operationFlow==Constants.UPDATE){
            binding.toolTitle.visibility = View.VISIBLE
            binding.changePwdTextCard.visibility = View.GONE
            binding.oldPasswordCard.visibility = View.VISIBLE
            binding.btnSetPwd.text = "Update"
        }
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSetPwd->{
                when(operationFlow){
                    Constants.UPDATE-> {
                        onBackPressed()
                    }
                    Constants.FORGOT->{
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        finish()
                    }
                }
            }
            binding.btnBack->{
                onBackPressed()
            }
        }
    }
}