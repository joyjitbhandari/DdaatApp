package com.example.ddaatapp.activity.blogs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.adapter.ArticleBlogAdapter
import com.example.ddaatapp.utils.GridListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityAllBlogBinding
import com.example.ddaatapp.model.responseDatamodel.BlogData
import com.example.ddaatapp.model.responseDatamodel.BlogDetails
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.Constants.IMAGE_URL
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.HomeViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class AllBlogActivity : BaseActivity() {
    private lateinit var binding : ActivityAllBlogBinding

    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,ViewModelFactory(RetrofitClient().apiService))[HomeViewModel::class.java]
        showProgressDialog()
        initObserver()
        viewModel.getAllBlog()

        binding.btnBack.setOnClickListener{
            onBackPressed()
        }
    }

    private fun initObserver() {
        viewModel.allBlogResponse.observe(this, Observer {
            hideProgressDialog()
            if(it.success) {
                setDataAdapter(it.data)
                Glide.with(this).load(IMAGE_URL+it.data[0].image).into(binding.articleImage)
                binding.txtArticleName.text = it.data[0].title

                val intent = Intent(this, BlogDetailsActivity::class.java)
                intent.putExtra("blog_id",it.data[0].id)
                binding.articleCard.setOnClickListener{
                    startActivity(intent)
                }
            }
            else
                showToast(it.message, Toast.LENGTH_SHORT)
        })

        viewModel.toastMsg.observe(this, EventObserver{
            hideProgressDialog()
            showToast(it,Toast.LENGTH_SHORT)
        })
    }

    private fun setDataAdapter(articleList:List<BlogData>){
        val articleRecyclerView = binding.articleRecyclerView
        val articleAdapter = ArticleBlogAdapter(articleList,this,true, articleList.size)
        articleRecyclerView.adapter = articleAdapter

        //Article item Decoration
        val articleSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        articleRecyclerView.addItemDecoration(GridListSpacingItemDecoration(articleSpacing))
    }
}