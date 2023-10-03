package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.subscription.SubscriptionActivity
import com.example.ddaatapp.databinding.ActivityInterestBinding
import com.example.ddaatapp.databinding.InterestChoiceChipItemBinding
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.Constants
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.CategoryViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver
import com.google.android.material.chip.Chip


class CategoryActivity :BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityInterestBinding
    private lateinit var operationFlow: String
    private lateinit var viewModel : CategoryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //View model initialized
        viewModel = ViewModelProvider(this, ViewModelFactory(RetrofitClient().apiService))[CategoryViewModel::class.java]

        //Network calling
        initObserver()
        showProgressDialog()
        viewModel.getCategoryList()


        //   Checking the operation flow
        operationFlow = intent.getStringExtra("operation").toString()
        if (operationFlow == Constants.EDIT){
            binding.btnNext.text = "Save"
            binding.toolTitle.text = "Edit Category"
        }
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
    private fun initObserver(){
        viewModel.categoryResponse.observe(this, Observer {
            hideProgressDialog()
            val list = arrayListOf<String>()
            if (it.success){
                // setup chips for categories list
                for (i in it.data.indices.reversed()){
                    list.add(it.data[i].name)
                }
                setupChip(list)
            }
        })

        viewModel.toastMsg.observe(this, EventObserver{
            hideProgressDialog()
            showToast(it,Toast.LENGTH_SHORT)
        })
    }

    private fun setupChip(interestList: ArrayList<String>) {
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
}