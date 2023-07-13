package com.example.ddaatapp.activity.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.ChatMessageAdapter
import com.example.ddaatapp.databinding.ActivityChatMessageBinding
import com.example.ddaatapp.utils.Constants

class ChatMessageActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityChatMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Chat view list setting
        val chatList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.TechSupportChatDataModel>(
            com.example.ddaatapp.model.responseDatamodel.TechSupportChatDataModel(
                Constants.RECEIVE_ID,
                "Cool, let's talk about it later, shall we? This is going to be a huge!! We already sent you the details bro.",
                "15:30"
            ),
            com.example.ddaatapp.model.responseDatamodel.TechSupportChatDataModel(
                Constants.SEND_ID,
                "Cool, let's talk about it later, shall we? This is going to be a huge!! We already sent you the details bro.",
                "15:30"
            ),
            com.example.ddaatapp.model.responseDatamodel.TechSupportChatDataModel(
                Constants.RECEIVE_ID,
                "Cool, let's talk about it later, shall we? This is going to be a huge!! We already sent you the details bro.",
                "15:30"
            ),
        )
        //getting chat receiver image it will come from json api
        val receiverImg = intent.getIntExtra("imageResId", R.drawable.user_profile_image)

        // setting chat adapter
        val chatView = binding.chatRecyclerView
        val adapter = ChatMessageAdapter(chatList,receiverImg)
        chatView.adapter = adapter
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
        }
    }
}