package com.example.ddaatapp.activity.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.databinding.ActivityNotificationSettingBinding


class NotificationSettingActivity : BaseActivity() {
    private lateinit var binding: ActivityNotificationSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Button notification
        binding.notification.setOnCheckedChangeListener { buttonView, isChecked ->
            // Save the checkbox state to shared preferences
            if (isChecked) {
                binding.notificationCard.setBackgroundResource(R.drawable.round_25_blue_bg)
            } else {
                binding.notificationCard.setBackgroundResource(R.drawable.round_25_black_stroke_shape)
            }

        }

        //Button Session update
        binding.sessionUpdate.setOnCheckedChangeListener { buttonView, isChecked ->
            // Save the checkbox state to shared preferences
            if (isChecked) {
                binding.sessionUpdateCard.setBackgroundResource(R.drawable.round_25_blue_bg)
            } else {
                binding.sessionUpdateCard.setBackgroundResource(R.drawable.round_25_black_stroke_shape)
            }
        }

        //Button Message update
        binding.messageUpdate.setOnCheckedChangeListener { buttonView, isChecked ->
            // Save the checkbox state to shared preferences
            if (isChecked) {
                binding.messageUpdateCard.setBackgroundResource(R.drawable.round_25_blue_bg)
            } else {
                binding.messageUpdateCard.setBackgroundResource(R.drawable.round_25_black_stroke_shape)
            }
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

}