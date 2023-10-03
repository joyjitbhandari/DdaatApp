package com.example.ddaatapp.activity.techSupport

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.adapter.FaqsAdapter
import com.example.ddaatapp.databinding.ActivityFaqBinding
import com.example.ddaatapp.model.responseDatamodel.FaqData
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.FAQViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class FAQActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFaqBinding
    private lateinit var viewModel: FAQViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View model set
        viewModel = ViewModelProvider(this, ViewModelFactory(RetrofitClient().apiService))[FAQViewModel::class.java]

        initObserver()
        showProgressDialog()
        viewModel.getFaq()
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

    private fun initObserver(){
        viewModel.apiResponse.observe(this){
            hideProgressDialog()
            if(it.success)
                setFaqListData(it.data.reversed())
            else
                showToast(it.message, Toast.LENGTH_SHORT)
        }
        viewModel.toastMsg.observe(this,EventObserver{
            hideProgressDialog()
            showToast(it, Toast.LENGTH_SHORT)
        })
    }

    private fun setFaqListData(faqsList:List<FaqData>){
        //adapter data set
        val faqsRecyclerView = binding.faqsRecycler
        val adapter = FaqsAdapter(faqsList)
        faqsRecyclerView.adapter = adapter
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        faqsRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
    }
}