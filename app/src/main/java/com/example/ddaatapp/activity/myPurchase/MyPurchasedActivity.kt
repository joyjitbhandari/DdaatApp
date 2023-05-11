package com.example.ddaatapp.activity.myPurchase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.MyPurchasedAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityMyPurchaseBinding
import com.example.ddaatapp.datamodel.MyPurchasedDataModel

class MyPurchasedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPurchaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set up My Purchased list
        val purchaseList = arrayListOf<MyPurchasedDataModel>(
            MyPurchasedDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been")
        )


        //setting up the list view adapter
        val myPurchasedRecycler = binding.myPurchasedRecycler
        val mypurchaseAdapter = MyPurchasedAdapter(purchaseList,purchaseList.size,this)
        myPurchasedRecycler.adapter =  mypurchaseAdapter
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        myPurchasedRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))




        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}