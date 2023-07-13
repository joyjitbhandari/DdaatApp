package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.ChatMessageItemBinding
import com.example.ddaatapp.responseDatamodel.TechSupportChatDataModel
import com.example.ddaatapp.`object`.Constants

class ChatMessageAdapter(private val chatList: ArrayList<com.example.ddaatapp.responseDatamodel.TechSupportChatDataModel>, private val receiverImg : Int ) :
    RecyclerView.Adapter<ChatMessageAdapter.ViewHolder>() {
    class ViewHolder(var binding:ChatMessageItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(techSupportChatDataModel: com.example.ddaatapp.responseDatamodel.TechSupportChatDataModel, receiverImg: Int){
            when(techSupportChatDataModel.id){
                Constants.SEND_ID->{
                    //visibility gone for receive view

                    binding.receiveViewCard.visibility = View.GONE
                    binding.receiveTime.visibility = View.GONE

                    //setting LogInData to view
                    binding.sendMessage.text = techSupportChatDataModel.currentMessage
                    binding.sendTime.text = techSupportChatDataModel.time

                }
                Constants.RECEIVE_ID->{
                    //visibility gone for send view
                    binding.sendViewCard.visibility = View.GONE
                    binding.sendTime.visibility = View.GONE

                    //setting LogInData to view
                    binding.receiverImage.setImageResource(receiverImg)
                    binding.receiveMessage.text = techSupportChatDataModel.currentMessage
                    binding.receiveTime.text = techSupportChatDataModel.time

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ChatMessageItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(chatList[position], receiverImg)
    }
}