package com.example.ddaatapp.activity.showVideoContent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.RelatedVideoCourseAdapter
import com.example.ddaatapp.adapter.VideoAndLectureSessionAdapter
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
                //setting up visibility
                binding.relatedVideoCard.visibility = View.VISIBLE
                binding.relatedLectureCard.visibility = View.GONE
                binding.lectureSessionCard.visibility = View.GONE
                binding.videoSessionCard.visibility = View.GONE


                val videoList = arrayListOf<VideoLibraryDataModel>(
                    VideoLibraryDataModel(R.drawable.video_session_img4,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img1,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img2,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img3,"Video Name","30:12 in Session")
                )
                val sessionVideoRecyclerView= binding.sessionVideoRecycler
                val adapter = VideoAndLectureSessionAdapter(videoList,this, true)
                sessionVideoRecyclerView.adapter = adapter
            }

            "PURCHASED"->{
                binding.txtContentName.text = "Course Name"
                //setting up visibility
                binding.relatedVideoCard.visibility = View.GONE
                binding.relatedLectureCard.visibility = View.VISIBLE
                binding.lectureSessionCard.visibility = View.VISIBLE
                binding.videoSessionCard.visibility = View.GONE

                //lecture session list
                val sessionList = arrayListOf<VideoLibraryDataModel>(
                    VideoLibraryDataModel(R.drawable.video_session_img4,"Audio Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img1,"Audio Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img2,"Audio Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_session_img3,"Audio Name","30:12 in Session")
                )
                val sessionlectureRecyclerView= binding.sessionLectureRecycler
                val sessionAdapter = VideoAndLectureSessionAdapter(sessionList,this,false)
                sessionlectureRecyclerView.adapter = sessionAdapter

                //related lecture list
                val lectureList = arrayListOf<VideoLibraryDataModel>(
                    VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image2,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image3,"Video Name","30:12 in Session"),
                    VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session")
                )
                val relatedLectureRecyclerView= binding.relatedLectureRecycler
                val lectureAdapter = RelatedVideoCourseAdapter(lectureList,4,this,false)
                relatedLectureRecyclerView.adapter = lectureAdapter
                //List item Decoration
                val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
                relatedLectureRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))

            }

            "COURSE"->{
                //setting course heading
                binding.txtContentName.text = "Course Name"
                //setting up visibility
                binding.relatedVideoCard.visibility = View.VISIBLE
                binding.relatedLectureCard.visibility = View.GONE
                binding.lectureSessionCard.visibility = View.GONE
                binding.videoSessionCard.visibility = View.GONE

                    //Related video list
                    val relatedVideoList = arrayListOf<VideoLibraryDataModel>(
                        VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session"),
                        VideoLibraryDataModel(R.drawable.video_sample_image2,"Video Name","30:12 in Session"),
                        VideoLibraryDataModel(R.drawable.video_sample_image3,"Video Name","30:12 in Session"),
                        VideoLibraryDataModel(R.drawable.video_sample_image,"Video Name","30:12 in Session")
                    )
                    // Setting top videos in recycler
                    val relatedVideoRecyclerView= binding.relatedVideoRecycler
                    val adapter = RelatedVideoCourseAdapter(relatedVideoList,4,this,true)
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

        }
    }
}