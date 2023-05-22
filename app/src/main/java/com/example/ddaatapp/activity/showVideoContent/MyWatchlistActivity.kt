package com.example.ddaatapp.activity.showVideoContent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.MyWatchListAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityMyWatchListBinding
import com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel

class MyWatchlistActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityMyWatchListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyWatchListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setting top videos in recycler
        //watchlist list
        val watchList = arrayListOf<VideoLibraryDataModel>(
            VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            VideoLibraryDataModel(R.drawable.video_sample_image2,"Video Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            VideoLibraryDataModel(R.drawable.video_sample_image3,"Video Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            VideoLibraryDataModel(R.drawable.video_sample_image3,"Video Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
        )

        val watchlistRecyclerView= binding.watchlistRecycler
        val adapter = MyWatchListAdapter(watchList,this)
        watchlistRecyclerView.adapter = adapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        watchlistRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
        }
    }
}