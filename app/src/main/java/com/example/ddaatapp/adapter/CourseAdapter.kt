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
import com.example.ddaatapp.responseDatamodel.CourseDataModel

class CourseAdapter(val videoList: ArrayList<com.example.ddaatapp.responseDatamodel.CourseDataModel>, private val itemCount:Int, val context: Context ) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {
    class ViewHolder(var binding:VideoLibraryListItemBinding ): RecyclerView.ViewHolder(binding.root ) {
        fun bind(courseDataModel: com.example.ddaatapp.responseDatamodel.CourseDataModel, mContext:AppCompatActivity, context: Context){
            binding.videoImage.setImageResource(courseDataModel.drawable)
            binding.txtVideoName.text = courseDataModel.name
            binding.txtVideoDesc.text = courseDataModel.desc

                //Checking its free or paid
                val isCourseFree = courseDataModel.isCourseFree
                if (isCourseFree==true){
                    binding.freePaidTag.visibility = View.VISIBLE
                    binding.freePaidTag.text = "Free"
                    binding.freePaidTag.setBackgroundResource(R.drawable.round_5dp_green_bg)

                    binding.root.setOnClickListener {
                        val operationFlow = "COURSE"
                        val intent = Intent(context, ShowVideoContentActivity::class.java)
                        intent.putExtra("operation",operationFlow)
                        intent.putExtra("course",isCourseFree)
                        mContext.startActivity(intent)
                    }
                }else if (isCourseFree==false){
                    binding.freePaidTag.visibility = View.VISIBLE
                    binding.freePaidTag.text = "Paid"
                    binding.freePaidTag.setBackgroundResource(R.drawable.round_5dp_yellow_bg)

                    binding.root.setOnClickListener {
                        val operationFlow = "COURSE"
                        val intent = Intent(context, ShowVideoContentActivity::class.java)
                        intent.putExtra("operation", operationFlow)
                        intent.putExtra("course", isCourseFree)
                        mContext.startActivity(intent)
                    }
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
       holder.bind(videoList[position], context as AppCompatActivity, context)
    }
}