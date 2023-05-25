package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.showVideoContent.ShowVideoContentActivity
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel
import com.example.ddaatapp.`object`.Constants

class MyWatchListAdapter(val videoList: ArrayList<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>, val context: Context) :
    RecyclerView.Adapter<MyWatchListAdapter.ViewHolder>() {
    class ViewHolder(var binding:VideoLibraryListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(videoLibraryDataModel: com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel, mContext:AppCompatActivity, context: Context){
            binding.videoImage.setImageResource(videoLibraryDataModel.drawable)
            binding.txtVideoName.text = videoLibraryDataModel.name
            binding.txtVideoDesc.text = videoLibraryDataModel.desc


            binding.root.setOnClickListener {
                val operationFlow = Constants.VIDEO
                val intent = Intent(context,ShowVideoContentActivity::class.java)
                intent.putExtra("operation",operationFlow)
                mContext.startActivity(intent)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            VideoLibraryListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {

      return videoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(videoList[position],context as AppCompatActivity, context)
    }
}