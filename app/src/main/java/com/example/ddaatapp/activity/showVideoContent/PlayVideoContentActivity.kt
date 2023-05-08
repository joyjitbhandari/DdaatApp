package com.example.ddaatapp.activity.showVideoContent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivityPlayVideoContentBinding

class PlayVideoContentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityPlayVideoContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayVideoContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }

        }
    }
}