package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.chat.ChatMessageActivity
import com.example.ddaatapp.databinding.NotificationListItemBinding
import com.example.ddaatapp.databinding.UnsubscribeChatListItemBinding
import com.example.ddaatapp.datamodel.NotificationDataModel
import com.example.ddaatapp.datamodel.UnsubscribeChatListDataModel

class UnsubscribeChatListAdapter(private val chatList: ArrayList<UnsubscribeChatListDataModel>, private val context: Context) :
    RecyclerView.Adapter<UnsubscribeChatListAdapter.ViewHolder>() {
    class ViewHolder(var binding:UnsubscribeChatListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(chatListDataModel: UnsubscribeChatListDataModel, mContext:AppCompatActivity, context: Context){

            binding.chatImage.setImageResource(chatListDataModel.drawable)
            binding.chatName.text = chatListDataModel.name
            binding.chatContent.text = chatListDataModel.content
            binding.chatTime.text = chatListDataModel.time

            binding.root.setOnClickListener {
                mContext.startActivity(Intent(context,ChatMessageActivity::class.java))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UnsubscribeChatListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(chatList[position], context as AppCompatActivity, context)
    }
}