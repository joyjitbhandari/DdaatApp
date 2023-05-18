package com.example.ddaatapp.activity.session

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivityWatingAreaBinding

class WatingAreaActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityWatingAreaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWatingAreaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
      when(view){
          binding.btnBack->{
              onBackPressed()
          }
          binding.btnStart->{
                startActivity(Intent(this,VideoCallActivity::class.java))
          }
      }
    }
}