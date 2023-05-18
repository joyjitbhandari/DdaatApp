package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.techSupport.TechSupportChatActivity
import com.example.ddaatapp.databinding.ArticleAndBlogItemBinding
import com.example.ddaatapp.databinding.TechSupportChatItemBinding
import com.example.ddaatapp.databinding.TicketListItemBinding
import com.example.ddaatapp.datamodel.TechSupportChatDataModel
import com.example.ddaatapp.datamodel.TicketDataModel
import com.example.ddaatapp.`object`.Constants

class TechSupportChatAdapter(val chatList: ArrayList<TechSupportChatDataModel>) :
    RecyclerView.Adapter<TechSupportChatAdapter.ViewHolder>() {
    class ViewHolder(var binding:TechSupportChatItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(techSupportChatDataModel: TechSupportChatDataModel){
            when(techSupportChatDataModel.id){
                Constants.SEND_ID->{
                    //visibility gone for receive view
                    binding.receiveViewCard.visibility = View.GONE
                    binding.receiveTime.visibility = View.GONE

                    //setting data to view
                    binding.sendMessage.text = techSupportChatDataModel.currentMessage
                    binding.sendTime.text = techSupportChatDataModel.time

                }
                Constants.RECEIVE_ID->{
                    //visibility gone for send view
                    binding.sendViewCard.visibility = View.GONE
                    binding.sendTime.visibility = View.GONE

                    //setting data to view
                    binding.receiveMessage.text = techSupportChatDataModel.currentMessage
                    binding.receiveTime.text = techSupportChatDataModel.time

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TechSupportChatItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(chatList[position])
    }
}