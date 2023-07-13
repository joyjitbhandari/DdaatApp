package com.example.ddaatapp.activity.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.signup.CompleteProfile
import com.example.ddaatapp.activity.signup.InterestActivity
import com.example.ddaatapp.databinding.ActivityMyProfileBinding
import com.example.ddaatapp.utils.Constants
import com.example.ddaatapp.utils.SavedData.profileData

class MyProfileActivity : BaseActivity() , View.OnClickListener {
    lateinit var binding : ActivityMyProfileBinding
    private val operationFlow = Constants.EDIT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting predefined data
        binding.profileName.text = profileData.name
        binding.txtBirthYear.text = profileData.birth_year
        binding.txtGender.text = profileData.gender
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