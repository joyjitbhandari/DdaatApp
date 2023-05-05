package com.example.ddaatapp.activity.aboutDdaat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.databinding.ActivityTearmsBinding

class TearmsActivity : AppCompatActivity() {
    private lateinit var binding :ActivityTearmsBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityTearmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnBack.setOnClickListener {
           onBackPressed()
       }
    }
}