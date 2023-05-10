package com.example.ddaatapp.activity.session

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.chat.ChatActivity
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.ActivityVideoCallBinding
import com.example.ddaatapp.subscriptionScreen.HomeActivity
import com.google.android.material.button.MaterialButton

class VideoCallActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding:ActivityVideoCallBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVideoCallBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnCallEnd->{
                val intent = Intent(this,VideoCallSessionCompleteActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            binding.btnChat->{
                startActivity(Intent(this,ChatActivity::class.java))
            }
            binding.btnNote->{
                ShowDialog(this).showWriteNoteDialog()
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