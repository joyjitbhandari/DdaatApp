package com.example.ddaatapp.activity.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.signup.CompleteProfile
import com.example.ddaatapp.activity.signup.InterestActivity
import com.example.ddaatapp.databinding.ActivityMyProfileBinding

class MyProfile : AppCompatActivity() , View.OnClickListener {
    lateinit var binding : ActivityMyProfileBinding
    private val operationFlow = "EDIT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
       when(view){
           binding.btnBack->{
               onBackPressed()
           }
           binding.btnEditProfile->{
               val intent = Intent(this, CompleteProfile::class.java)
               intent.putExtra("operation",operationFlow)
               startActivity(intent)

           }
           binding.btnEditCategory->{
               val intent = Intent(this, InterestActivity::class.java)
               intent.putExtra("operation",operationFlow)
               startActivity(intent)
           }
       }
    }
}