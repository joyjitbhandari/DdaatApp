package com.example.ddaatapp.activity.signup

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.ActivityCompleteProfileBinding
import com.example.ddaatapp.databinding.DialogGenderPickerBinding
import com.example.ddaatapp.databinding.DialogTypeGenderBinding
import com.example.ddaatapp.`object`.Constants
import java.util.*


class CompleteProfile : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCompleteProfileBinding

    private lateinit var operationFlow: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompleteProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


//   Checking the operation flow
        operationFlow = intent.getStringExtra("operation").toString()
        if (operationFlow == Constants.EDIT) {
            binding.btnNext.text = "Save"
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnNext -> {
                when (operationFlow) {
                    Constants.EDIT -> {
                        onBackPressed()
                    }
                    Constants.SIGN_UP -> {
                        val operationFlow = Constants.SIGN_UP
                        val intent = Intent(this, InterestActivity::class.java)
                        intent.putExtra("operation", operationFlow)
                        startActivity(intent)
                    }
                }
            }

            binding.btnBack -> {
                onBackPressed()
            }

            binding.etBirthYear -> {
                showDatePickerDialog()
            }
            binding.btnNext -> {
                val intent = Intent(this, InterestActivity::class.java)
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
                binding.etBirthYear.setText( year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)
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
                binding.selectGender.text = genderBinding.checkMale.text
                genderBinding.checkFemale.isChecked = false
                genderBinding.checkOther.isChecked = false
            } else {
                binding.selectGender.text = R.string.select.toString()
            }
        }
        genderBinding.checkFemale.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                binding.selectGender.text = genderBinding.checkFemale.text
                genderBinding.checkMale.isChecked = false
                genderBinding.checkOther.isChecked = false
            }
        }

        genderBinding.checkOther.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                showTypeGenderDialog()
                genderBinding.checkMale.isChecked = false
                genderBinding.checkFemale.isChecked = false
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


            typeGenderBinding.btnCut.setOnClickListener {
                dialog.dismiss()

            }
        }
    }
}
