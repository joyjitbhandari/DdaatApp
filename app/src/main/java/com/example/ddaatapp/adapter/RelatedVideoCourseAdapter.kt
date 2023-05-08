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
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

class RelatedVideoCourseAdapter(val videoList: ArrayList<VideoLibraryDataModel>, private val itemCount:Int, var context: Context) :
    RecyclerView.Adapter<RelatedVideoCourseAdapter.ViewHolder>() {
    class ViewHolder(var binding:RelatedVideoCourseListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(videoLibraryDataModel: VideoLibraryDataModel, mContext:AppCompatActivity, context: Context){
            binding.videoImage.setImageResource(videoLibraryDataModel.drawable)
            binding.txtVideoName.text = videoLibraryDataModel.name
            binding.txtVideoDesc.text = videoLibraryDataModel.desc


            binding.root.setOnClickListener {
                val operationFlow = "VIDEO"
                val intent = Intent(context,ShowVideoContentActivity::class.java)
                intent.putExtra("operation",operationFlow)
                mContext.startActivity(intent)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RelatedVideoCourseListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {

      return itemCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(videoList[position],context as AppCompatActivity, context)
    }
}