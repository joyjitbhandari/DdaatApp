package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.FaqsListItemBinding
import com.example.ddaatapp.model.responseDatamodel.FaqData

class FaqsAdapter(val faqsList: List<FaqData>) :
    RecyclerView.Adapter<FaqsAdapter.ViewHolder>() {
    class ViewHolder(var binding:FaqsListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        private var isExpand = true
        fun bind(item: FaqData){
            binding.textFaqQuestion.text = item.title
            binding.textFaqAnswer.text = item.description

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