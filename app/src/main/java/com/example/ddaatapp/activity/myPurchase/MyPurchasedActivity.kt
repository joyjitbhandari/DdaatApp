package com.example.ddaatapp.activity.myPurchase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.MyPurchasedAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityMyPurchaseBinding

class MyPurchasedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPurchaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set up My Purchased list
        val purchaseList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel>(
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image2,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image3,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image3,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image3,
                "Podcast Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image2,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyPurchasedDataModel(
                R.drawable.video_sample_image3,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            )
        )


        //setting up the list view adapter
        val myPurchasedRecycler = binding.myPurchasedRecycler
        val myPurchaseAdapter = MyPurchasedAdapter(purchaseList,purchaseList.size,this)
        myPurchasedRecycler.adapter =  myPurchaseAdapter
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        myPurchasedRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))




        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}