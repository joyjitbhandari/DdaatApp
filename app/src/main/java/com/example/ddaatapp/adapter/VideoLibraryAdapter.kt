package com.example.ddaatapp.adapter

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

class VideoLibraryAdapter(val videoList: ArrayList<VideoLibraryDataModel>, private val itemCount:Int) :
    RecyclerView.Adapter<VideoLibraryAdapter.ViewHolder>() {
    class ViewHolder(var binding:VideoLibraryListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(videoLibraryDataModel: VideoLibraryDataModel){
            binding.videoImage.setImageResource(videoLibraryDataModel.drawable)
            binding.txtVideoName.text = videoLibraryDataModel.name
            binding.txtVideoDesc.text = videoLibraryDataModel.desc


            //Checking its free or paid
           val isCourseFree = videoLibraryDataModel.isCourseFree
            if (isCourseFree==true){
                binding.freePaidTag.visibility = View.VISIBLE
                binding.freePaidTag.text = "Free"
                binding.freePaidTag.setBackgroundResource(R.drawable.round_5dp_green_bg)
            }else if (isCourseFree==false){
                binding.freePaidTag.visibility = View.VISIBLE
                binding.freePaidTag.text = "Paid"
                binding.freePaidTag.setBackgroundResource(R.drawable.round_5dp_yellow_bg)
            }else{
                binding.freePaidTag.visibility = View.GONE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            VideoLibraryListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {

      return itemCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(videoList[position])
    }
}