package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.FaqsListItemBinding
import com.example.ddaatapp.responseDatamodel.FaqsDataModel

class FaqsAdapter(val faqsList: ArrayList<com.example.ddaatapp.responseDatamodel.FaqsDataModel>) :
    RecyclerView.Adapter<FaqsAdapter.ViewHolder>() {
    class ViewHolder(var binding:FaqsListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        private var isExpand = true
        fun bind(faqsDataModel: com.example.ddaatapp.responseDatamodel.FaqsDataModel){
            binding.textFaqQuestion.text = faqsDataModel.faqsQuestion
            binding.textFaqAnswer.text = faqsDataModel.faqsAnswer

            binding.root.setOnClickListener {
                if (isExpand) {
                    binding.textFaqAnswer.visibility = View.VISIBLE
                    binding.btnDropdown.setIconResource(R.drawable.ic_expand_less_arrow)
                    isExpand = !isExpand
                } else {
                    binding.textFaqAnswer.visibility = View.GONE
                    binding.btnDropdown.setIconResource(R.drawable.ic_expand_more_arrow)
                    isExpand = !isExpand
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FaqsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return faqsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(faqsList[position])
    }
}