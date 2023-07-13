package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.showVideoContent.ShowVideoContentActivity
import com.example.ddaatapp.databinding.RelatedVideoCourseListItemBinding
import com.example.ddaatapp.utils.Constants

class RelatedVideoCourseAdapter(val videoList: ArrayList<com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel>, private val itemCount:Int, val context: Context, val isVideo:Boolean) :
    RecyclerView.Adapter<RelatedVideoCourseAdapter.ViewHolder>() {
    class ViewHolder(var binding:RelatedVideoCourseListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(videoLibraryDataModel: com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel, mContext:AppCompatActivity, context: Context, isVideo: Boolean){
            binding.videoImage.setImageResource(videoLibraryDataModel.drawable)
            binding.txtVideoName.text = videoLibraryDataModel.name
            binding.txtVideoDesc.text = videoLibraryDataModel.desc

            if(isVideo){
                binding.root.setOnClickListener {
                    binding.playButton.visibility = View.VISIBLE
                    val operationFlow = Constants.VIDEO
                    val intent = Intent(context,ShowVideoContentActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    mContext.startActivity(intent)

                }
            }else{
                binding.playButton.visibility = View.GONE
                binding.root.setOnClickListener {
                    val operationFlow = Constants.COURSE
                    val intent = Intent(context,ShowVideoContentActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    mContext.startActivity(intent)
                }
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
       holder.bind(videoList[position],context as AppCompatActivity, context ,isVideo)
    }
}