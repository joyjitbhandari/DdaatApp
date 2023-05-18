package com.example.ddaatapp.activity.session

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.databinding.ActivityPastSessionHistoryBinding

class PastSessionHistoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPastSessionHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPastSessionHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}