package com.example.ddaatapp.activity.superPower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivitySurveyQuestionAnswerBinding

class SurveyQuestionAnswerActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySurveyQuestionAnswerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyQuestionAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressedDispatcher
            }
            binding.btnNext->{
                startActivity(Intent(this,SurveyResultActivity::class.java))
            }
        }
    }
}