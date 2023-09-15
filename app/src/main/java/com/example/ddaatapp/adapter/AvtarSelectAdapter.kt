package com.example.ddaatapp.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.AvtarListItemBinding
import com.example.ddaatapp.model.AvtarListModel
import com.example.ddaatapp.utils.setVisible

class AvtarSelectAdapter(
    private val dataSet: ArrayList<AvtarListModel>,
    private val onAvtarClick: (avtar:Int) -> Unit,
) : RecyclerView.Adapter<AvtarSelectAdapter.ViewHolder>() {
    private var selectedImagePosition = 0
    class ViewHolder(val binding: AvtarListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AvtarListModel) {
            binding.avatar1.setImageResource(item.imageSrc)
            binding.selectedIndicator.setVisible(item.selected)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AvtarListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onAvtarClick(item.imageSrc)
            for (i in dataSet.indices) {
                dataSet[i].selected = i == position
            }
            notifyDataSetChanged()
        }
    }
}