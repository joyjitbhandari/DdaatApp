package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.showVideoContent.ShowVideoContentActivity
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.datamodel.MyPurchasedDataModel
import com.example.ddaatapp.`object`.Constants

class MyPurchasedAdapter(val videoList: ArrayList<MyPurchasedDataModel>, private val itemCount:Int, val context: Context ) :
    RecyclerView.Adapter<MyPurchasedAdapter.ViewHolder>() {
    class ViewHolder(var binding:VideoLibraryListItemBinding ): RecyclerView.ViewHolder(binding.root ) {
        fun bind(myPurchaseDataModel: MyPurchasedDataModel, mContext:AppCompatActivity, context: Context){
            binding.videoImage.setImageResource(myPurchaseDataModel.drawable)
            binding.txtVideoName.text = myPurchaseDataModel.name
            binding.txtVideoDesc.text = myPurchaseDataModel.desc

                binding.root.setOnClickListener {
                    val operationFlow = Constants.PURCHASED
                    val intent = Intent(context, ShowVideoContentActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    mContext.startActivity(intent)
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
       holder.bind(videoList[position],context as AppCompatActivity, context)
    }
}