package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.articleAndBlog.ArticleActivity
import com.example.ddaatapp.databinding.ArticleAndBlogItemBinding
import com.example.ddaatapp.responseDatamodel.ArticleDataModel

class ArticleBlogAdapter(val articleList: ArrayList<com.example.ddaatapp.responseDatamodel.ArticleDataModel>, val context:Context, private val isBlog:Boolean) :
    RecyclerView.Adapter<ArticleBlogAdapter.ViewHolder>() {
    class ViewHolder(var binding:ArticleAndBlogItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(articleDataModel: com.example.ddaatapp.responseDatamodel.ArticleDataModel, mContext:AppCompatActivity, context: Context, isBlog: Boolean){
            if(isBlog){
                binding.blogArticleCard.visibility = View.VISIBLE
                binding.homeArticleView.visibility = View.GONE

                binding.blogCardBgImage.setImageResource(articleDataModel.drawable)
                binding.txtBlogName.text = articleDataModel.articleName
                binding.txtBlogDesc.text = articleDataModel.articleDesc
                binding.txtBlogAuthor.text = articleDataModel.articleAuthor
                binding.txtBlogDate.text = articleDataModel.artileDate
            }else{
                binding.blogArticleCard.visibility = View.GONE
                binding.homeArticleView.visibility = View.VISIBLE

                binding.articleCardBgImage.setImageResource(articleDataModel.drawable)
                binding.txtArticleName.text = articleDataModel.articleName
                binding.txtArticleDesc.text = articleDataModel.articleDesc
                binding.txtArticleAuthor.text = articleDataModel.articleAuthor
                binding.txtArticleDate.text = articleDataModel.artileDate
            }

            binding.root.setOnClickListener {
                mContext.startActivity(Intent(context,ArticleActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ArticleAndBlogItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(articleList[position], context as AppCompatActivity, context, isBlog)
    }
}