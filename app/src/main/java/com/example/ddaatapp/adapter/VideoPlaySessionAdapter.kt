package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.showVideoContent.ShowVideoContentActivity
import com.example.ddaatapp.databinding.RelatedVideoCourseListItemBinding
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.databinding.VideoPlaySessionListItemBinding
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

class VideoPlaySessionAdapter(val sessionList: ArrayList<VideoLibraryDataModel>,var context: Context) :
    RecyclerView.Adapter<VideoPlaySessionAdapter.ViewHolder>() {
    class ViewHolder(var binding: VideoPlaySessionListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(videoLibraryDataModel: VideoLibraryDataModel, mContext:AppCompatActivity, context: Context){
            binding.videoImage.setImageResource(videoLibraryDataModel.drawable)
            binding.txtVideoName.text = videoLibraryDataModel.name
            binding.txtVideoDesc.text = videoLibraryDataModel.desc

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            VideoPlaySessionListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return sessionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(sessionList[position],context as AppCompatActivity, context)
        holder.binding.textNumber.text = position.toString()
    }
}