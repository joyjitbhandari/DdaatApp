package com.example.ddaatapp.activity.aboutDdaat

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.txtTermAndCondition->{
                startActivity(Intent(this,TearmsActivity::class.java))
            }
            binding.txtPrivacyPolicy->{
                startActivity(Intent(this,PrivacyActivity::class.java))
            }
        }
    }
}