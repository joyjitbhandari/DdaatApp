package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.paymentAndBilling.AddNewCardActivity
import com.example.ddaatapp.databinding.AtmCardItemBinding
import com.example.ddaatapp.responseDatamodel.AtmCardDataModel

class AtmCardAdapter(val cardList: ArrayList<AtmCardDataModel>, val context:Context) :
    RecyclerView.Adapter<AtmCardAdapter.ViewHolder>() {
    class ViewHolder(var binding:AtmCardItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(atmCardDataModel: AtmCardDataModel, mContext:AppCompatActivity, context: Context){
            binding.cardBg.setImageResource(atmCardDataModel.backgroundImage)
            binding.cardType.setImageResource(atmCardDataModel.cardLogo)
            binding.txtCardNumber.text = atmCardDataModel.cardNumber
            binding.txtCardHolderName.text = atmCardDataModel.cardHolderName
            binding.txtCarExpiryDate.text = atmCardDataModel.cardExpiryDate

            binding.btnEditCard.setOnClickListener {
                val operationFlow = "EDIT"
                val intent = Intent(context, AddNewCardActivity::class.java)
                intent.putExtra("operation", operationFlow)
                mContext.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AtmCardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return cardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(cardList[position], context as AppCompatActivity, context)
    }
}