package com.example.ddaatapp.activity.showVideoContent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.RelatedVideoCourseAdapter
import com.example.ddaatapp.adapter.VideoLibraryAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityShowVideoContentBinding
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

class ShowVideoContentActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding:ActivityShowVideoContentBinding
    private lateinit var operationFlow:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowVideoContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()

        when(operationFlow){
            "VIDEO"->{
                // Setting top videos in recycler
                //video list
                val videoList = arrayListOf<VideoLibraryDataModel>(
                    VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image2,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image3,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image3,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session"),
                )

                val relatedVideoRecyclerView= binding.relatedVideoRecycler
                val adapter = RelatedVideoCourseAdapter(videoList,4,this)
                relatedVideoRecyclerView.adapter = adapter
                //List item Decoration
                val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
                relatedVideoRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
            }
        }


    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }

            binding.btnPlayContent->{
                if(operationFlow=="VIDEO"){
                   val intent = Intent(this,PlayVideoContentActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    startActivity(intent)
                }


            }
        }
    }
}