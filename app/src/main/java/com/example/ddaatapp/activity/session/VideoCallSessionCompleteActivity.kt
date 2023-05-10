package com.example.ddaatapp.activity.session

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.databinding.ActivityVideoCallSessionCompleteBinding
import com.example.ddaatapp.subscriptionScreen.HomeActivity

class VideoCallSessionCompleteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoCallSessionCompleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoCallSessionCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}