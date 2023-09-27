package com.example.ddaatapp.activity.signup

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.adapter.AvtarSelectAdapter
import com.example.ddaatapp.databinding.ActivityCompleteProfileBinding
import com.example.ddaatapp.databinding.DialogGenderPickerBinding
import com.example.ddaatapp.databinding.DialogTypeGenderBinding
import com.example.ddaatapp.model.AvtarListModel
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.Constants
import com.example.ddaatapp.utils.SavedData
import com.example.ddaatapp.utils.SavedData.profileData
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.ProfileViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver
import com.flynaut.healthtag.util.PrefsManager
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList


class CompleteProfile : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCompleteProfileBinding

    private lateinit var operationFlow: String
    private lateinit var viewModel: ProfileViewModel
    private lateinit var avtarAdapter : AvtarSelectAdapter
    private lateinit var avtarList : ArrayList<AvtarListModel>

    private  var gender : String = ""

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitClient().apiService)
        )[ProfileViewModel::class.java]
        binding = ActivityCompleteProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserver()
//   Checking the operation flow
        operationFlow = intent.getStringExtra("operation").toString()
        if (operationFlow == Constants.EDIT) {
            binding.toolTitle.text = "Edit Profile"
            binding.btnNext.text = "Save"
        //setting predefined data
            binding.etUserName.setText(profileData.name)
            binding.etBirthYear.setText(profileData.birth_year)
            binding.selectGender.text = profileData.gender
        }else{
            showProgressDialog()
            viewModel.getProfile()
        }

        avtarList = arrayListOf(
            AvtarListModel(R.drawable.avatar4,false),
            AvtarListModel(R.drawable.avatar2,false),
            AvtarListModel(R.drawable.avatar3,false),
            AvtarListModel(R.drawable.avatar4,false))

        val avtarRecycler = binding.avatarRecycler
        avtarAdapter = AvtarSelectAdapter(avtarList) {image->

        }
        avtarRecycler.adapter = avtarAdapter
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnNext -> {
                showProgressDialog()
                viewModel.updateProfile(
                    com.example.ddaatapp.model.requestDatamodel.UpdateProfileRequest(
                        binding.etUserName.text.toString(),
                        gender,
                        binding.etBirthYear.text.toString()
                    )
                )
            }

            binding.btnBack -> {
                onBackPressed()
            }

            binding.etBirthYear -> {
                showDatePickerDialog()
            }
            binding.btnNext -> {
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
            }

            binding.selectGender -> {
//               binding.genderSpinner.visibility = View.VISIBLE
                showGenderPickerDialog()
            }

            binding.btnBack -> {
                onBackPressed()
            }
        }
    }


    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                binding.etBirthYear.setText(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun showGenderPickerDialog() {
        val genderBinding = DialogGenderPickerBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(genderBinding.root)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
        }
        dialog.show()

        genderBinding.checkMale.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                gender = "Male"
                binding.selectGender.text = genderBinding.checkMale.text
                genderBinding.checkFemale.isChecked = false
                genderBinding.checkOther.isChecked = false
                dialog.dismiss()
            }
        }
        genderBinding.checkFemale.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                gender = "Female"
                binding.selectGender.text = genderBinding.checkFemale.text
                genderBinding.checkMale.isChecked = false
                genderBinding.checkOther.isChecked = false
                dialog.dismiss()
            }
        }

        genderBinding.checkOther.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                showTypeGenderDialog()
                genderBinding.checkMale.isChecked = false
                genderBinding.checkFemale.isChecked = false
                dialog.dismiss()
            }
        }
    }


    private fun showTypeGenderDialog() {
        val typeGenderBinding = DialogTypeGenderBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(typeGenderBinding.root)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            typeGenderBinding.btnAdd.setOnClickListener {
                if(typeGenderBinding.etTypeGender.toString().isEmpty()){
                    typeGenderBinding.etTypeGender.error = "Enter Gender"
                }else {
                    gender = typeGenderBinding.etTypeGender.text.toString()
                    binding.selectGender.text = gender
                    dialog.dismiss()
                }

            }
            typeGenderBinding.btnCut.setOnClickListener {
                dialog.dismiss()

            }
        }
    }

    private fun initObserver() {
        viewModel.getProfileResponse.observe(this){
            hideProgressDialog()
            if(it.success){
                //setting predefined data
                binding.etUserName.setText(it.data.name)
            }else
                showToast(it.message,Toast.LENGTH_SHORT)

        }
        viewModel.updateProfileResponse.observe(this) {
            hideProgressDialog()
            if(it?.success == true){
//                profileData = it.data
                PrefsManager.get().save(
                    PrefsManager.PREF_PROFILE,
                    Gson().toJson(it.data)
                )
                SavedData.loadProfileData()
                when (operationFlow) {
                    Constants.EDIT -> {
                        showToast(it.message)
                        onBackPressed()
                    }
                    Constants.SIGN_UP -> {
                        showToast(it.message)
                        val intent = Intent(this, CategoryActivity::class.java)
                        intent.putExtra("operation", operationFlow)
                        startActivity(intent)
                    }
                }
            }else{
                showToast(it?.message.toString())
            }

        }
        viewModel.toastMsg.observe(this, EventObserver {
            hideProgressDialog()
            this.showToast(it, Toast.LENGTH_SHORT)
        })
    }

}
