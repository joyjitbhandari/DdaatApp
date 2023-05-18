package com.example.ddaatapp.activity.techSupport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivityCreateTicketBinding

class CreateTicketActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding : ActivityCreateTicketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
       when(view){
           binding.btnBack->{
               onBackPressed()
           }
           binding.btnSendMessage->{
               startActivity(Intent(this,TechSupportChatActivity::class.java))
               finish()
           }
       }
    }
}