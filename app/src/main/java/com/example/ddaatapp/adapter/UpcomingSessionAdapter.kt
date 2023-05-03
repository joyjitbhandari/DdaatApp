package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.UpcommoingSessionsListItemBinding
import com.example.ddaatapp.datamodel.UpcomingSessionDataModel

class UpcomingSessionAdapter(val sessionList: ArrayList<UpcomingSessionDataModel>, private val itemCount:Int) :
    RecyclerView.Adapter<UpcomingSessionAdapter.ViewHolder>() {
    class ViewHolder(var binding:UpcommoingSessionsListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(upcommingSessionDataModel: UpcomingSessionDataModel){
            binding.sessionImage.setImageResource(upcommingSessionDataModel.drawable)
            binding.sessionHeading.text = upcommingSessionDataModel.name
            binding.sessionType.text = upcommingSessionDataModel.type
            binding.sessionDate.text = upcommingSessionDataModel.date

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UpcommoingSessionsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return itemCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(sessionList[position])
    }
}