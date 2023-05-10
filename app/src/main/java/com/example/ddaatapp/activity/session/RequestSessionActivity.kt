package com.example.ddaatapp.activity.session

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivityRequestSessionBinding

class RequestSessionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRequestSessionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestSessionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnSubmit->{
                onBackPressed()
            }
        }
    }
}