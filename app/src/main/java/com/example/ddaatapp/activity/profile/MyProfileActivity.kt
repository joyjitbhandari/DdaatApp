package com.example.ddaatapp.activity.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.signup.CompleteProfile
import com.example.ddaatapp.activity.signup.CategoryActivity
import com.example.ddaatapp.databinding.ActivityMyProfileBinding
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.Constants
import com.example.ddaatapp.utils.SavedData.profileData
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.ProfileViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class MyProfileActivity : BaseActivity() , View.OnClickListener {
    private lateinit var viewModel: ProfileViewModel
    lateinit var binding : ActivityMyProfileBinding
    private val operationFlow = Constants.EDIT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitClient().apiService)
        )[ProfileViewModel::class.java]

        initObserver()
        showProgressDialog()
        viewModel.getProfile()

//        //setting predefined data
//        binding.profileName.text = profileData.name
//        binding.txtBirthYear.text = profileData.birth_year
//        binding.txtGender.text = profileData.gender
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
               val intent = Intent(this, CategoryActivity::class.java)
               intent.putExtra("operation",operationFlow)
               startActivity(intent)
           }
       }
    }

    fun initObserver(){
        viewModel.getProfileResponse.observe(this){
            hideProgressDialog()
            if(it.success){
                //setting predefined data
                binding.profileName.text = it.data.name
                binding.txtBirthYear.text = it.data.birth_year
                binding.txtGender.text = it.data.gender
            }else
                showToast(it.message,Toast.LENGTH_SHORT)

        }
        viewModel.toastMsg.observe(this,EventObserver{
            hideProgressDialog()
            showToast(it,Toast.LENGTH_SHORT)
        })
    }

    override fun onRestart() {
        super.onRestart()
        finish()
        startActivity(intent)
    }
}