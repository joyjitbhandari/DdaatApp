package com.example.ddaatapp.adapter

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.ArticleAndBlogItemBinding
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.datamodel.ArticleDataModel
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

class ArticleBlogAdapter(val articleList: ArrayList<ArticleDataModel>) :
    RecyclerView.Adapter<ArticleBlogAdapter.ViewHolder>() {
    class ViewHolder(var binding:ArticleAndBlogItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(articleDataModel: ArticleDataModel){
            binding.articleCardBgImage.setImageResource(articleDataModel.drawable)
            binding.txtArticleName.text = articleDataModel.articleName
            binding.txtArticleDesc.text = articleDataModel.articleDesc
            binding.txtArticleAuthor.text = articleDataModel.articleAuthor
            binding.txtArticleDate.text = articleDataModel.artileDate
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
       holder.bind(articleList[position])
    }
}