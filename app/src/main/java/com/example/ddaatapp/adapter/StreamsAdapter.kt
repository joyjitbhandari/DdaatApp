package com.example.ddaatapp.adapter

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.datamodel.StreamsDataModel
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

class StreamsAdapter(val videoList: ArrayList<StreamsDataModel>, private val itemCount:Int) :
    RecyclerView.Adapter<StreamsAdapter.ViewHolder>() {
    class ViewHolder(var binding:VideoLibraryListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(streamsDataModel: StreamsDataModel){
            binding.videoImage.setImageResource(streamsDataModel.drawable)
            binding.txtVideoName.text = streamsDataModel.name
            binding.txtVideoDesc.text = streamsDataModel.desc

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