package com.example.ddaatapp.activity.techSupport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.FaqsAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityTechSupportBinding

class TechSupportActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTechSupportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        FAQS List
        val faqsList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.FaqsDataModel>(
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            )
        //adapter
        val faqsRecyclerView = binding.faqsRecycler
        val adapter = FaqsAdapter(faqsList)
        faqsRecyclerView.adapter = adapter
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        faqsRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))


    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnBack -> {
                onBackPressed()
            }
            binding.btnChat->{
                    startActivity(Intent(this,TechSupportTicketActivity::class.java))
            }
        }
    }
}