package com.example.ddaatapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.VideoPlaySessionListItemBinding
import com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel

class VideoAndLectureSessionAdapter(val sessionList: ArrayList<VideoLibraryDataModel>, var context: Context , var isVideo:Boolean) :
    RecyclerView.Adapter<VideoAndLectureSessionAdapter.ViewHolder>() {
    class ViewHolder(var binding: VideoPlaySessionListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(videoLibraryDataModel: VideoLibraryDataModel, mContext:AppCompatActivity, context: Context, isVideo: Boolean){
            binding.videoImage.setImageResource(videoLibraryDataModel.drawable)
            binding.txtVideoName.text = videoLibraryDataModel.name
            binding.txtVideoDesc.text = videoLibraryDataModel.desc

            if(isVideo){
                binding.playButton.visibility = View.VISIBLE
            }else{
                binding.playButton.visibility = View.GONE
            }

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
       holder.bind(sessionList[position],context as AppCompatActivity, context, isVideo)
        holder.binding.textNumber.text = position.toString()
    }
}