package com.example.ddaatapp.activity.blogs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.adapter.ArticleBlogAdapter
import com.example.ddaatapp.utils.GridListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityAllBlogBinding
import com.example.ddaatapp.model.responseDatamodel.BlogData
import com.example.ddaatapp.model.responseDatamodel.BlogDetails
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.BlogViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class AllBlogActivity : BaseActivity() , View.OnClickListener {
    private lateinit var binding : ActivityAllBlogBinding

    private lateinit var viewModel: BlogViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,ViewModelFactory(RetrofitClient().apiService))[BlogViewModel::class.java]
        showProgressDialog()
        initObserver()
        viewModel.getAllBlog()
//        // for article view
//        val articleList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.ArticleDataModel>(
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
//                R.drawable.article_bg_img,
//                "Lorem Ipsum is simply dummy text",
//                "Lorem Ipsum is simply dummy text of the printing and.....",
//                "June 04, 2022",
//                "Smith"
//            ),
//
//        )


    }

    private fun initObserver() {
        viewModel.allBlogResponse.observe(this, Observer {
            hideProgressDialog()
            if(it.success)
                setDataAdapter(it.data)
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
        val articleAdapter = ArticleBlogAdapter(articleList,this,true)
        articleRecyclerView.adapter = articleAdapter

        //Article item Decoration
        val articleSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        articleRecyclerView.addItemDecoration(GridListSpacingItemDecoration(articleSpacing))
    }

    override fun onClick(view: View?) {
       when(view){
           binding.articleCard->{
               startActivity(Intent(this,BlogDetailsActivity::class.java))
           }
           binding.btnBack->{
               onBackPressed()
           }
       }
    }
}