package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.subscription.BuySubscriptionActivity
import com.example.ddaatapp.activity.subscription.SubscriptionDetailsActivity
import com.example.ddaatapp.databinding.SubscriptionCardItemBinding
import com.example.ddaatapp.responseDatamodel.SubscriptionDataModel
import com.example.ddaatapp.`object`.Constants

class SubscriptionAdapter(private val cardList: ArrayList<com.example.ddaatapp.responseDatamodel.SubscriptionDataModel>, var context: Context, var isAfterSignIn: Boolean) :
    RecyclerView.Adapter<SubscriptionAdapter.ViewHolder>() {
    class ViewHolder(var binding:SubscriptionCardItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(subscriptionDataModel: com.example.ddaatapp.responseDatamodel.SubscriptionDataModel, mContext:AppCompatActivity, context: Context, isAfterSignIn: Boolean){

            binding.subsCardBG.setImageResource(subscriptionDataModel.bg)
            binding.cardImage.setImageResource(subscriptionDataModel.symbol)
            binding.cardPlanName.text = subscriptionDataModel.planeName
            binding.price.text = subscriptionDataModel.price
            binding.cardDesc.text = subscriptionDataModel.desc
            binding.cardInfo.text = subscriptionDataModel.subsInfo


            if(isAfterSignIn){
                if(subscriptionDataModel.isSubscribed){
                    binding.btnContinue.text = "Subscribed"
                    binding.root.setOnClickListener {
                        val intent = Intent(context,SubscriptionDetailsActivity::class.java)
                        mContext.startActivity(intent)
                    }

                }else{
                    binding.btnContinue.text = "Subscribe"
                    binding.root.setOnClickListener {
                        val intent = Intent(context,SubscriptionDetailsActivity::class.java)
                        mContext.startActivity(intent)
                    }
                    binding.btnContinue.setOnClickListener {
                        val operationFlow = Constants.SUBSCRIPTION
                        val intent = Intent(context,BuySubscriptionActivity::class.java)
                        intent.putExtra("operation",operationFlow)
                        mContext.startActivity(intent)
                    }
                }

            }else{
                binding.btnContinue.text = "Continue"
                binding.btnContinue.setOnClickListener {
                    val operationFlow = Constants.SIGN_UP
                    val intent = Intent(context,BuySubscriptionActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    mContext.startActivity(intent)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SubscriptionCardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {

      return cardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(cardList[position],context as AppCompatActivity, context, isAfterSignIn)
    }
}