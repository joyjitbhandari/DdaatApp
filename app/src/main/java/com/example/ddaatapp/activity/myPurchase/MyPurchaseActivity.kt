package com.example.ddaatapp.activity.myPurchase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.MyNotesAdapter
import com.example.ddaatapp.adapter.MyPurchaseAdapter
import com.example.ddaatapp.databinding.ActivityMyPurchaseBinding
import com.example.ddaatapp.datamodel.MyPurchaseDataModel

class MyPurchaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPurchaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val purchaseList = arrayListOf<MyPurchaseDataModel>(
            MyPurchaseDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            MyPurchaseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null)
        )


        //setting up the list view adapter
        val myPurchaseRecycler = binding.myPurchaseRecyclerView
        val mypurchaseAdapter = MyPurchaseAdapter(purchaseList,purchaseList.size)
        myPurchaseRecycler.adapter =  mypurchaseAdapter



        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}