package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.techSupport.TechSupportChatActivity
import com.example.ddaatapp.databinding.TicketListItemBinding
import com.example.ddaatapp.responseDatamodel.TicketDataModel

class TicketAdapter(val ticketList: ArrayList<TicketDataModel>, val context:Context) :
    RecyclerView.Adapter<TicketAdapter.ViewHolder>() {
    class ViewHolder(var binding:TicketListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(ticketDataModel: TicketDataModel, mContext:AppCompatActivity, context: Context){

            binding.txtTicketTitle.text = ticketDataModel.ticketTitle
            binding.txtTicketStatus.text = ticketDataModel.ticketStatus
            binding.txtTicketDesc.text = ticketDataModel.ticketDesc
            binding.txtTicketDateTime.text = ticketDataModel.ticketDateTime

            binding.root.setOnClickListener {
                mContext.startActivity(Intent(context,TechSupportChatActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TicketListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return ticketList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(ticketList[position], context as AppCompatActivity, context)
    }
}