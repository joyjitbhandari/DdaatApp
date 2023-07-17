package com.example.ddaatapp.activity.blogs

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.databinding.ActivityArticleBinding
import com.example.ddaatapp.model.responseDatamodel.BlogData
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.Constants.IMAGE_URL
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.HomeViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class BlogDetailsActivity : BaseActivity(), View.OnClickListener{
    private lateinit var binding: ActivityArticleBinding
    private lateinit var viewModel : HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, ViewModelFactory(RetrofitClient().apiService))[HomeViewModel::class.java]
        val blogId = intent.getIntExtra("blog_id", 0)
        initObserver()
        showProgressDialog()
        val field = HashMap<String,Int>()
        field["blog_id"] = blogId
        viewModel.getBolgDetails(field)
    }

    private fun initObserver() {
        viewModel.blogDetailsResponse.observe(this, Observer {
            hideProgressDialog()
            if(it.success){
                hideProgressDialog()
                setView(it.data)
            }
            else
                showToast(it.message, Toast.LENGTH_SHORT)
        })

        viewModel.toastMsg.observe(this, EventObserver{
            hideProgressDialog()
            showToast(it, Toast.LENGTH_SHORT)
        })
    }

    private fun setView(data: BlogData) {
        Glide.with(this).load(IMAGE_URL+data.image).into(binding.articleImage)
        binding.txtArticleHeading.text = data.title
        binding.txtArticleBody.text = data.description
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
               onBackPressed()
            }
        }
    }
}