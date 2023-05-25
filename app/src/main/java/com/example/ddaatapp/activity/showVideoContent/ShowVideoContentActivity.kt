package com.example.ddaatapp.activity.showVideoContent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.playStreamAudio.StreamAudioPlayActivity
import com.example.ddaatapp.adapter.RelatedVideoCourseAdapter
import com.example.ddaatapp.adapter.VideoAndLectureSessionAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityShowVideoContentBinding
import com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel
import com.example.ddaatapp.`object`.Constants

class ShowVideoContentActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding:ActivityShowVideoContentBinding
    private lateinit var operationFlow:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowVideoContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()

        when(operationFlow){
            Constants.VIDEO->{
                binding.videoSessionCard.visibility = View.GONE
                binding.lectureSessionCard.visibility = View.GONE
                binding.relatedLectureCard.visibility = View.GONE
                binding.relatedVideoCard.visibility = View.VISIBLE
                binding.commentsCard.visibility = View.VISIBLE


                //video list
                val videoList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image2,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image3,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image,
                        "Video Name",
                        "30:12 in Session"
                    )
                )
                // Setting top videos in recycler
                val relatedVideoRecyclerView= binding.relatedVideoRecycler
                val adapter = RelatedVideoCourseAdapter(videoList,4,this,true)
                relatedVideoRecyclerView.adapter = adapter
                //List item Decoration
                val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
                relatedVideoRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))

                //Button operation
                binding.btnPlayContent.setOnClickListener {
                    val intent = Intent(this, PlayVideoContentActivity::class.java)
                    intent.putExtra("operation", operationFlow)
                    startActivity(intent)
                }
            }

            Constants.PURCHASED->{
                binding.btnPlayContent.text = "Start Course"
                binding.txtContentName.text = "Course Name"

                //Setting visibility
                binding.videoSessionCard.visibility = View.GONE
                binding.lectureSessionCard.visibility = View.VISIBLE
                binding.relatedLectureCard.visibility = View.VISIBLE
                binding.relatedVideoCard.visibility = View.GONE
                binding.commentsCard.visibility = View.GONE

                //lecture session list
                val sessionList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_session_img4,
                        "Audio Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_session_img1,
                        "Audio Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_session_img2,
                        "Audio Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_session_img3,
                        "Audio Name",
                        "30:12 in Session"
                    )
                )
                val sessionlectureRecyclerView= binding.sessionLectureRecycler
                val sessionAdapter = VideoAndLectureSessionAdapter(sessionList,this,false)
                sessionlectureRecyclerView.adapter = sessionAdapter

                //related lecture list
                val lectureList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image2,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image3,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image,
                        "Video Name",
                        "30:12 in Session"
                    )
                )

                val relatedLectureRecyclerView= binding.relatedLectureRecycler
                val lectureAdapter = RelatedVideoCourseAdapter(lectureList,4,this,false)
                relatedLectureRecyclerView.adapter = lectureAdapter
                //List item Decoration
                val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
                relatedLectureRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))

                //Button operation
                binding.btnPlayContent.setOnClickListener {
                    val intent = Intent(this, PlayVideoContentActivity::class.java)
                    intent.putExtra("operation", operationFlow)
                    startActivity(intent)
                }
            }

            Constants.COURSE->{
                //setting course heading
                binding.txtContentName.text = "Course Name"

                val isCourseFree = intent.getBooleanExtra("course",true)
                if(isCourseFree){
                    //setting button Text
                    binding.btnPlayContent.text = "Start Course"
                    //setting up visibility
                    binding.videoSessionCard.visibility = View.VISIBLE
                    binding.lectureSessionCard.visibility = View.GONE
                    binding.relatedLectureCard.visibility = View.GONE
                    binding.relatedVideoCard.visibility = View.VISIBLE
                    binding.commentsCard.visibility = View.GONE

                    //video session list
                    val sessionList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_session_img4,
                            "Audio Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_session_img1,
                            "Audio Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_session_img2,
                            "Audio Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_session_img3,
                            "Audio Name",
                            "30:12 in Session"
                        )
                    )
                    val sessionVideoRecyclerView= binding.sessionVideoRecycler
                    val sessionAdapter = VideoAndLectureSessionAdapter(sessionList,this,true)
                    sessionVideoRecyclerView.adapter = sessionAdapter


                    //Related video list
                    val relatedVideoList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image,
                            "Video Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image2,
                            "Video Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image3,
                            "Video Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image,
                            "Video Name",
                            "30:12 in Session"
                        )
                    )
                    // Setting top videos in recycler
                    val relatedVideoRecyclerView= binding.relatedVideoRecycler
                    val adapter = RelatedVideoCourseAdapter(relatedVideoList,4,this,true)
                    relatedVideoRecyclerView.adapter = adapter
                    //List item Decoration
                    val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
                    relatedVideoRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))

                    //Button operation
                    binding.btnPlayContent.setOnClickListener {
                        val intent = Intent(this, PlayVideoContentActivity::class.java)
                        intent.putExtra("operation", operationFlow)
                        startActivity(intent)
                    }

                }else{
                    //setting button Text
                    binding.btnPlayContent.text = "Purchase Course"
                    //setting up visibility
                    binding.videoSessionCard.visibility = View.GONE
                    binding.lectureSessionCard.visibility = View.GONE
                    binding.relatedLectureCard.visibility = View.GONE
                    binding.relatedVideoCard.visibility = View.VISIBLE
                    binding.commentsCard.visibility = View.GONE

                    // Setting top videos in recycler
                    //video list
                    val videoList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image,
                            "Video Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image2,
                            "Video Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image3,
                            "Video Name",
                            "30:12 in Session"
                        ),
                        com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                            R.drawable.video_sample_image,
                            "Video Name",
                            "30:12 in Session"
                        )
                    )

                    val relatedVideoRecyclerView= binding.relatedVideoRecycler
                    val adapter = RelatedVideoCourseAdapter(videoList,4,this,true)
                    relatedVideoRecyclerView.adapter = adapter
                    //List item Decoration
                    val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
                    relatedVideoRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))

                    //Button operation
                    binding.btnPlayContent.setOnClickListener {

                        //other payment activity will open here

                    }
                }
            }
            Constants.UNSUBSCRIBE->{
                binding.videoSessionCard.visibility = View.GONE
                binding.lectureSessionCard.visibility = View.GONE
                binding.relatedLectureCard.visibility = View.GONE
                binding.relatedVideoCard.visibility = View.VISIBLE
                binding.commentsCard.visibility = View.VISIBLE


                //video list
                val videoList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image2,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image3,
                        "Video Name",
                        "30:12 in Session"
                    ),
                    com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                        R.drawable.video_sample_image,
                        "Video Name",
                        "30:12 in Session"
                    )
                )
                // Setting top videos in recycler
                val relatedVideoRecyclerView= binding.relatedVideoRecycler
                val adapter = RelatedVideoCourseAdapter(videoList,4,this,true)
                relatedVideoRecyclerView.adapter = adapter
                //List item Decoration
                val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
                relatedVideoRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))

                binding.btnPlayContent.setOnClickListener {
                    val intent = Intent(this,StreamAudioPlayActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    startActivity(intent)
                }
            }
        }

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnShare->{}
        }
    }
}