package com.example.ddaatapp.activity.forgot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.LoginActivity
import com.example.ddaatapp.databinding.ActivityChangePwdBinding

class ChangePwdActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityChangePwdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePwdBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSetPwd->{
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }
        }
    }
}