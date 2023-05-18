package com.example.ddaatapp.activity.session

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.chat.ChatClickActivity
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.ActivityVideoCallBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.subscriptionScreen.CoursesActivity

class VideoCallActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding:ActivityVideoCallBinding
    private var isMicOn = false
    private var isVideoCamOn = false

    private lateinit var operationFlow: String
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVideoCallBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()

        if(operationFlow == Constants.LIVE){
            binding.personList.visibility = View.VISIBLE
            binding.btnPersons.visibility = View.VISIBLE
            binding.outgoingImage.visibility = View.GONE
            binding.btnNote.visibility = View.GONE
        }
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnCallEnd->{
                if(operationFlow == Constants.LIVE){
                    val intent = Intent(this,CoursesActivity::class.java)
                    finish()
                    startActivity(intent)

                }else{
                    val intent = Intent(this,VideoCallSessionCompleteActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }

            }
            binding.btnChat->{
                startActivity(Intent(this,ChatClickActivity::class.java))
            }
            binding.btnNote->{
                ShowDialog(this).showWriteNoteDialog()
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

//    private fun showSessionCompleteDialog(){
//        val dialog = Dialog(this, android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen)
//        dialog.setContentView(R.layout.activity_video_call_session_complete)
//        dialog.window?.apply {
//            setLayout(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//            )
//            setGravity(Gravity.CENTER)
//            dialog.show()
//
//            val submitButton = dialog.findViewById<MaterialButton>(R.id.btn_submit)
//            submitButton.setOnClickListener {
//                dialog.dismiss()
//                val intent = Intent(dialog.context,HomeActivity::class.java)
//                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(intent)
//            }
//        }
//    }
}