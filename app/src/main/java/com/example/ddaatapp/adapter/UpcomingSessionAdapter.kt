package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.session.JoinSessionActivity
import com.example.ddaatapp.databinding.UpcomingSessionsListItemBinding
import com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel

class UpcomingSessionAdapter(val sessionList: ArrayList<UpcomingSessionDataModel>, private val itemCount:Int, val context: Context) :
    RecyclerView.Adapter<UpcomingSessionAdapter.ViewHolder>() {
    class ViewHolder(var binding:UpcomingSessionsListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(upcommingSessionDataModel: UpcomingSessionDataModel,mcontext:AppCompatActivity, context: Context){
            binding.sessionImage.setImageResource(upcommingSessionDataModel.drawable)
            binding.sessionHeading.text = upcommingSessionDataModel.name
            binding.sessionType.text = upcommingSessionDataModel.type
            binding.sessionDate.text = upcommingSessionDataModel.date

            binding.root.setOnClickListener {
                mcontext.startActivity(Intent(context, JoinSessionActivity::class.java))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UpcomingSessionsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return itemCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(sessionList[position],context as AppCompatActivity, context)
    }
}