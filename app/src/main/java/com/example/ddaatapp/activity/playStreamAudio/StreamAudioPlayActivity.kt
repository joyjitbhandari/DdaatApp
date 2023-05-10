package com.example.ddaatapp.activity.playStreamAudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.databinding.ActivityStreamAudioPlayBinding

class StreamAudioPlayActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var binding:ActivityStreamAudioPlayBinding
    private lateinit var operationFlow : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStreamAudioPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Getting flow from intent
        operationFlow = intent.getStringExtra("operation").toString()

        if(operationFlow == "PODCAST"){
            binding.txtContentName.text = "Podcast Title"
        }else{
            binding.txtContentName.text = "Stream Title"
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnBack -> {
                onBackPressed()
            }
        }
    }
}