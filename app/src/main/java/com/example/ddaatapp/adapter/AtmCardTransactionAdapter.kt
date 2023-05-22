package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.AtmCardTransactionHistoryItemBinding
import com.example.ddaatapp.responseDatamodel.AtmCardTransactionDataModel

class AtmCardTransactionAdapter(val transList: ArrayList<AtmCardTransactionDataModel>) :
    RecyclerView.Adapter<AtmCardTransactionAdapter.ViewHolder>() {
    class ViewHolder(var binding:AtmCardTransactionHistoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(atmCardTransactionDataModel: AtmCardTransactionDataModel){
            binding.transSymbol.setImageResource(atmCardTransactionDataModel.transSymbol)
            binding.txtTransName.text = atmCardTransactionDataModel.transName
            binding.txtTransReason.text =atmCardTransactionDataModel.transReason
            binding.txtAmount.text = atmCardTransactionDataModel.amount
            binding.txtDate.text = atmCardTransactionDataModel.date

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AtmCardTransactionHistoryItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return transList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(transList[position])
    }
}