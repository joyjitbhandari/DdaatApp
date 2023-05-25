package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.NotificationListItemBinding
import com.example.ddaatapp.responseDatamodel.NotificationDataModel

class NotificationAdapter(val notificationList: ArrayList<com.example.ddaatapp.responseDatamodel.NotificationDataModel>) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    class ViewHolder(var binding:NotificationListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(notificationDataModel: com.example.ddaatapp.responseDatamodel.NotificationDataModel){

            binding.notifyImage.setImageResource(notificationDataModel.drawable)
            binding.notifyContent.text = notificationDataModel.content
            binding.notifyTime.text = notificationDataModel.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NotificationListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return notificationList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(notificationList[position])
    }
}