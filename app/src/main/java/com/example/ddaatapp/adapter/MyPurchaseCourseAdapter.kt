package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.datamodel.MyPurchaseCourseDataModel

class MyPurchaseCourseAdapter(val videoList: ArrayList<MyPurchaseCourseDataModel>, private val itemCount:Int) :
    RecyclerView.Adapter<MyPurchaseCourseAdapter.ViewHolder>() {
    class ViewHolder(var binding:VideoLibraryListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(myPurchaseDataModel: MyPurchaseCourseDataModel){
            binding.videoImage.setImageResource(myPurchaseDataModel.drawable)
            binding.txtVideoName.text = myPurchaseDataModel.name
            binding.txtVideoDesc.text = myPurchaseDataModel.desc


            //Checking its free or paid
           val isCourseFree = myPurchaseDataModel.isCourseFree
            if (isCourseFree==true){
                binding.freePaidTag.visibility = View.VISIBLE
                binding.freePaidTag.text = "Free"
                binding.freePaidTag.setBackgroundResource(R.drawable.round_5dp_green_bg)
            }else if (isCourseFree==false){
                binding.freePaidTag.visibility = View.VISIBLE
                binding.freePaidTag.text = "Paid"
                binding.freePaidTag.setBackgroundResource(R.drawable.round_5dp_yellow_bg)
            }else{
                binding.freePaidTag.visibility = View.GONE
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
       holder.bind(videoList[position])
    }
}