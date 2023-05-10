package com.example.ddaatapp.activity.showVideoContent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.RelatedVideoCourseAdapter
import com.example.ddaatapp.adapter.VideoPlaySessionAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityPlayVideoContentBinding
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

class PlayVideoContentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityPlayVideoContentBinding
    private lateinit var operationFlow:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayVideoContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()
        when(operationFlow){
            "VIDEO"->{
                // Setting top videos in recycler
                //video list
                val videoList = arrayListOf<VideoLibraryDataModel>(
                    VideoLibraryDataModel(R.drawable.video_session_img4,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img1,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img2,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img3,"Video Name","30:12 in Session")
                )
                val sessionVideoRecyclerView= binding.sessionVideoRecycler
                val adapter = VideoPlaySessionAdapter(videoList,this)
                sessionVideoRecyclerView.adapter = adapter
            }
        }
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }

        }
    }
}