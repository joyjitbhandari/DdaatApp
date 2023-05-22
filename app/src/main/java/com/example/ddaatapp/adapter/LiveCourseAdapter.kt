package com.example.ddaatapp.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.liveCourse.JoinLiveCourseActivity
import com.example.ddaatapp.databinding.LiveCourseListItemBinding
import com.example.ddaatapp.responseDatamodel.LiveCourseDataModel

class LiveCourseAdapter(val liveCourseList: ArrayList<LiveCourseDataModel>, var context: Context) :
    RecyclerView.Adapter<LiveCourseAdapter.ViewHolder>() {

    class ViewHolder(var binding:LiveCourseListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(liveCourseDataModel: LiveCourseDataModel, mContext:AppCompatActivity, context: Context){
            binding.liveCourseImage.setImageResource(liveCourseDataModel.drawable)
            binding.txtLiveCourseHeading.text = liveCourseDataModel.courseName

            binding.root.setOnClickListener {
                mContext.startActivity(Intent(context,JoinLiveCourseActivity::class.java))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LiveCourseListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return liveCourseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(liveCourseList[position],  context as AppCompatActivity, context )

    }
}