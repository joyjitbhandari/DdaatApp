package com.example.ddaatapp.activity.techSupport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.FaqsAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityTechSupportBinding
import com.example.ddaatapp.datamodel.FaqsDataModel

class TechSupportActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTechSupportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        FAQS List
        val faqsList = arrayListOf<FaqsDataModel>(
            FaqsDataModel("Lorem Ipsum is simply ?" , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."),
            FaqsDataModel("Lorem Ipsum is simply ?" , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."),
            FaqsDataModel("Lorem Ipsum is simply ?" , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."),
            FaqsDataModel("Lorem Ipsum is simply ?" , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."),
            FaqsDataModel("Lorem Ipsum is simply ?" , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."),
            FaqsDataModel("Lorem Ipsum is simply ?" , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."),
            FaqsDataModel("Lorem Ipsum is simply ?" , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."),
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