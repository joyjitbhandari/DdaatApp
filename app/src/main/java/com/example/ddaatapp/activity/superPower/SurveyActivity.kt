package com.example.ddaatapp.activity.superPower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivitySurveyBinding

class SurveyActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySurveyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnStartSurvey->{
                startActivity(Intent(this,SurveyQuestionAnswerActivity::class.java))
                finish()
            }

        }
    }
}