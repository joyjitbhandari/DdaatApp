package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ddaatapp.activity.blogs.BlogDetailsActivity
import com.example.ddaatapp.databinding.ArticleAndBlogItemBinding
import com.example.ddaatapp.model.responseDatamodel.BlogData
import com.example.ddaatapp.model.responseDatamodel.BlogDetails
import com.example.ddaatapp.utils.Constants.BASE_URL
import com.example.ddaatapp.utils.Constants.IMAGE_URL
import com.example.ddaatapp.utils.DateFormat
import com.example.ddaatapp.utils.DateUtils
import com.google.android.gms.common.data.DataHolder

class ArticleBlogAdapter(val articleList: List<BlogData>, val context:Context, private val isBlog:Boolean, private val itemCount:Int) :
    RecyclerView.Adapter<ArticleBlogAdapter.ViewHolder>() {
    class ViewHolder(var binding:ArticleAndBlogItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(blogData: BlogData, mContext:AppCompatActivity, context: Context, isBlog: Boolean){
            if(isBlog){
                binding.blogArticleCard.visibility = View.VISIBLE
                binding.homeArticleView.visibility = View.GONE

                Glide.with(binding.root.context)
                    .load("$IMAGE_URL${blogData.image}")
                    .into(binding.blogCardBgImage)
                binding.txtBlogName.text = blogData.title
                binding.txtBlogDesc.text = blogData.description
                binding.txtBlogAuthor.text = blogData.status // replace with author
                binding.txtBlogDate.text = DateUtils.convertUtcToCustomFormat(blogData.created_at,DateFormat.DATE_FORMAT)
            }else{
                binding.blogArticleCard.visibility = View.GONE
                binding.homeArticleView.visibility = View.VISIBLE

                Glide.with(binding.root.context)
                    .load("$IMAGE_URL${blogData.image}")
                    .into(binding.articleCardBgImage)
                binding.txtArticleName.text = blogData.title
                binding.txtArticleDesc.text = blogData.description
                binding.txtArticleAuthor.text = blogData.status // replace with author
                binding.txtArticleDate.text = DateUtils.convertUtcToCustomFormat(blogData.created_at,DateFormat.DATE_FORMAT)
            }

            binding.root.setOnClickListener {
                val intent = Intent(context, BlogDetailsActivity::class.java)
                intent.putExtra("blog_id", blogData.id)
                mContext.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ArticleAndBlogItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return itemCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(articleList[position], context as AppCompatActivity, context, isBlog)
    }
}