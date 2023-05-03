package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.subscription.BuySubscriptionActivity
import com.example.ddaatapp.databinding.SubscriptionCardItemBinding
import com.example.ddaatapp.datamodel.SubscriptionModel

class SubscriptionAdapter(val context: Context, var subsList: ArrayList<SubscriptionModel>): BaseAdapter(){
    override fun getCount(): Int {
        return  subsList.size
    }

    override fun getItem(position: Int): SubscriptionModel {
       return subsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var myconvertview = convertView

        if (myconvertview != null) {
            myconvertview =
                LayoutInflater.from(context).inflate(R.layout.subscription_card_item, parent, false)
        }

        val binding = SubscriptionCardItemBinding.inflate(LayoutInflater.from(context))
        val currentitem = getItem(position)

        binding.c1Image.setImageResource(R.drawable.img_subs_card)
        binding.c1BtnContinue.setOnClickListener {

        }

        return myconvertview
    }

}