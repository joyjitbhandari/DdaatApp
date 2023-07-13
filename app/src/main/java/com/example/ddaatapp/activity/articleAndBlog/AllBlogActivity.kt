package com.example.ddaatapp.activity.articleAndBlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.ArticleBlogAdapter
import com.example.ddaatapp.utils.GridListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityAllBlogBinding

class AllBlogActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding : ActivityAllBlogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // for article view
        val articleList = arrayListOf<com.example.ddaatapp.responseDatamodel.ArticleDataModel>(
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),

        )
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
               startActivity(Intent(this,ArticleActivity::class.java))
           }
           binding.btnBack->{
               onBackPressed()
           }
       }
    }
}