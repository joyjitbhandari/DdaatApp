package com.example.ddaatapp.activity.techSupport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.adapter.TechSupportChatAdapter
import com.example.ddaatapp.databinding.ActivityTechSupportChatBinding
import com.example.ddaatapp.responseDatamodel.TechSupportChatDataModel
import com.example.ddaatapp.`object`.Constants

class TechSupportChatActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityTechSupportChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechSupportChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Chat view list setting
        val chatList = arrayListOf<TechSupportChatDataModel>(
            TechSupportChatDataModel(Constants.SEND_ID,"Cool, let's talk about it later, shall we? This is going to be a huge!! We already sent you the details bro.","15:30"),
            TechSupportChatDataModel(Constants.RECEIVE_ID,"Cool, let's talk about it later, shall we? This is going to be a huge!! We already sent you the details bro.","15:30"),
            TechSupportChatDataModel(Constants.RECEIVE_ID,"Cool, let's talk about it later, shall we? This is going to be a huge!! We already sent you the details bro.","15:30"),
        )
        val techChatRecyclerView = binding.techSupportChatRecycler
        val adapter = TechSupportChatAdapter(chatList)
        techChatRecyclerView.adapter = adapter

    }

    override fun onClick(view: View?) {
       when(view){
           binding.btnBack->{
               onBackPressed()
           }
       }
    }
}