package com.example.ddaatapp.utils
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import com.example.ddaatapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class DynamicInterestChipCreator(private val context: Context)  {

    fun setupChip(chipGroup: ChipGroup) {
        val interestList =
            arrayListOf(
                "Need Motivation",
                "Fitness",
                "Business",
                "Job",
                "Relationship",
                "Feeling Lonely",
                "Careers")
        for (name in interestList) {
            val chip = createChip(name)
            chipGroup.addView(chip)
        }
    }

    @SuppressLint("InflateParams")
    private fun createChip(label: String): Chip {
        val chip = LayoutInflater.from(context).inflate(R.layout.interest_choice_chip_item, null) as Chip
        chip.text = label

        //setting padding
        val padding1 = context.resources.getDimension(R.dimen._20dp).toInt()
        val padding2 = context.resources.getDimension(R.dimen._18dp).toInt()
        chip.setPadding(padding1, padding2, padding1, padding2)
        return chip
    }
}