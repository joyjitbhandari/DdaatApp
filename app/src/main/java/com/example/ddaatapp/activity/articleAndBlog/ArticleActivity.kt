package com.example.ddaatapp.activity.articleAndBlog

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.ddaatapp.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
               onBackPressedDispatcher
            }
        }
    }
}