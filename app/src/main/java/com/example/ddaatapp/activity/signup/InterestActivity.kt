package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.subscription.SubscriptionActivity
import com.example.ddaatapp.databinding.ActivityInterestBinding
import com.example.ddaatapp.databinding.InterestChoiceChipItemBinding
import com.google.android.material.chip.Chip


class InterestActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityInterestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupChip()

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
                val intent = Intent(this, SubscriptionActivity::class.java)
                startActivity(intent)
            }
            binding.btnBack -> {
                onBackPressed()
            }
        }
    }
}