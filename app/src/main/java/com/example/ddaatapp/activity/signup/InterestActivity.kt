package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.subscription.SubscriptionActivity
import com.example.ddaatapp.databinding.ActivityInterestBinding
import com.example.ddaatapp.databinding.InterestChoiceChipItemBinding
import com.example.ddaatapp.utils.Constants
import com.google.android.material.chip.Chip


class InterestActivity :BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityInterestBinding
    private lateinit var operationFlow: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterestBinding.inflate(layoutInflater)
        setContentView(binding.root)
// setup chips for categories list
        setupChip()

        //   Checking the operation flow
        operationFlow = intent.getStringExtra("operation").toString()
        if (operationFlow == Constants.EDIT){
            binding.btnNext.text = "Save"
            binding.toolTitle.text = "Edit Category"
        }
    }

    private fun setupChip() {
        val interestList =
            arrayListOf(
                "How to use app",
                "Adulthood how to",
                "Celebrity Dats",
                "Educational Tips",
                "Life Hacks",
                "Life skills",
                "Fitness",
                "Business",
                "Managing Crises",
                "Need Motivation",
                "Financial Literacy",
                "Careers")
        for (name in interestList) {
            val chip = createChip(name)
            binding.chipGroup.addView(chip)
        }
    }

    private fun createChip(label: String): Chip {
        val chip = InterestChoiceChipItemBinding.inflate(layoutInflater).root
        chip.text = label

        //setting padding
        val padding = resources.getDimension(R.dimen._20dp).toInt()
        chip.setPadding(padding, padding, padding, padding)
        return chip
    }


    override fun onClick(view: View?) {
        when (view) {
            binding.btnNext -> {
               when(operationFlow){
                   Constants.EDIT->{
                       onBackPressed()
                   }
                   Constants.SIGN_UP->{
                       val operationFlow = Constants.SIGN_UP
                       val intent = Intent(this, SubscriptionActivity::class.java)
                       intent.putExtra("operation", operationFlow)
                       startActivity(intent)
                   }
                }
            }
            binding.btnBack -> {
                onBackPressed()
            }
        }
    }
}