package com.example.ddaatapp.activity.myPurchase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.MyPurchaseCourseAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityMyPurchaseBinding
import com.example.ddaatapp.datamodel.MyPurchaseCourseDataModel

class MyPurchaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPurchaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val purchaseList = arrayListOf<MyPurchaseCourseDataModel>(
            MyPurchaseCourseDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null)
        )


        //setting up the list view adapter
        val myPurchaseRecycler = binding.myPurchaseRecyclerView
        val mypurchaseAdapter = MyPurchaseCourseAdapter(purchaseList,purchaseList.size)
        myPurchaseRecycler.adapter =  mypurchaseAdapter
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        myPurchaseRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))




        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}