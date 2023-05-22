package com.example.ddaatapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.ReviewAndRatingItemBinding
import com.example.ddaatapp.responseDatamodel.ReviewAndRatingDataModel

class ReviewAndRatingAdapter(val ratingList: ArrayList<ReviewAndRatingDataModel>, var context: Context) :
    RecyclerView.Adapter<ReviewAndRatingAdapter.ViewHolder>() {
    class ViewHolder(var binding:ReviewAndRatingItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(reviewAndRatingDataModel: ReviewAndRatingDataModel, mContext:AppCompatActivity, context: Context){

            binding.mentorImage.setImageResource(reviewAndRatingDataModel.drawable)
            binding.txtMentorName.text = reviewAndRatingDataModel.mentorName
            binding.txtDateTime.text = reviewAndRatingDataModel.dateTime
            binding.txtRatingBody.text = reviewAndRatingDataModel.ratingBody

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ReviewAndRatingItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {

      return ratingList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(ratingList[position],context as AppCompatActivity, context)
    }
}