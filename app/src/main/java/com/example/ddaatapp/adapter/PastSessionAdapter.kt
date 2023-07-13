package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.session.PastSessionHistoryActivity
import com.example.ddaatapp.databinding.PastSessionsListItemBinding
import com.example.ddaatapp.model.responseDatamodel.PastSessionDataModel

class PastSessionAdapter(val sessionList: ArrayList<com.example.ddaatapp.model.responseDatamodel.PastSessionDataModel>, val context: Context) :
    RecyclerView.Adapter<PastSessionAdapter.ViewHolder>() {
    class ViewHolder(var binding: PastSessionsListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pastSessionDataModel: com.example.ddaatapp.model.responseDatamodel.PastSessionDataModel, mcontext : AppCompatActivity, context: Context){
            binding.sessionImage.setImageResource(pastSessionDataModel.drawable)
            binding.sessionHeading.text = pastSessionDataModel.name
            binding.sessionType.text = pastSessionDataModel.type

            binding.root.setOnClickListener {
                mcontext.startActivity(Intent(context,PastSessionHistoryActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PastSessionsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return sessionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(sessionList[position],context as AppCompatActivity, context)
    }
}