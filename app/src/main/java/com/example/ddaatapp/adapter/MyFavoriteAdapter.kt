package com.example.ddaatapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.RelatedVideoCourseListItemBinding
import com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel

class MyFavoriteAdapter(val videoList: ArrayList<VideoLibraryDataModel>,val context: Context) :
    RecyclerView.Adapter<MyFavoriteAdapter.ViewHolder>() {
    class ViewHolder(var binding:RelatedVideoCourseListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(videoLibraryDataModel: VideoLibraryDataModel){
            binding.btnAddFav.visibility = View.VISIBLE
            binding.videoImage.setImageResource(videoLibraryDataModel.drawable)
            binding.txtVideoName.text = videoLibraryDataModel.name
            binding.txtVideoDesc.text = videoLibraryDataModel.desc

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RelatedVideoCourseListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return videoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(videoList[position])
    }
}