package com.example.ddaatapp.activity.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivityChatMessageBinding

class ChatMessageActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityChatMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setting chat view data
        val chatView = binding.chatRecyclerView
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
        }
    }
}