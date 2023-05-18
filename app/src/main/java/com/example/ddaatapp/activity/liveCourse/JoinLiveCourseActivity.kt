package com.example.ddaatapp.activity.liveCourse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.session.VideoCallActivity
import com.example.ddaatapp.activity.showVideoContent.ShowVideoContentActivity
import com.example.ddaatapp.databinding.ActivityJoinLiveCourseBinding
import com.example.ddaatapp.`object`.Constants

class JoinLiveCourseActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityJoinLiveCourseBinding
    private var isMicOn = false
    private var isVideoCamOn = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinLiveCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnJoinSession->{
                val operationFlow = Constants.LIVE
                val intent = Intent(this, VideoCallActivity::class.java)
                intent.putExtra("operation",operationFlow)
                startActivity(intent)
                finish()
            }
            binding.btnMic->{
                if(isMicOn){
                    binding.btnMic.setIconResource(R.drawable.ic_mic)
                    binding.btnMic.setBackgroundColor(getColor(R.color.blue_bg))

                }else{
                    binding.btnMic.setIconResource(R.drawable.ic_mic_off)
                    binding.btnMic.setBackgroundColor(getColor(R.color.black_bg))
                }
                isMicOn = !isMicOn
            }
            binding.btnVideoCam->{
                if(isVideoCamOn){
                    binding.btnVideoCam.setIconResource(R.drawable.ic_videocam)
                    binding.btnVideoCam.setBackgroundColor(getColor(R.color.blue_bg))

                }else{
                    binding.btnVideoCam.setIconResource(R.drawable.ic_videocam_off)
                    binding.btnVideoCam.setBackgroundColor(getColor(R.color.black_bg))
                }
                isVideoCamOn= !isVideoCamOn
            }
        }
    }
}