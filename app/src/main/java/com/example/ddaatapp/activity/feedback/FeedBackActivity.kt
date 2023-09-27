package com.example.ddaatapp.activity.feedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.databinding.ActivityFeedBackBinding

class FeedBackActivity : BaseActivity() {
    private lateinit var binding : ActivityFeedBackBinding
    private var selectedEmoji: ImageView? = null
    private var selectedText: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //by default selected
        selectedEmoji = binding.star3
        selectedText = "Happy"

        //sating selected view
        binding.star1.setOnClickListener { onRatingChanged(1, binding.star1) }
        binding.star2.setOnClickListener { onRatingChanged(2, binding.star2) }
        binding.star3.setOnClickListener { onRatingChanged(3, binding.star3) }
        binding.star4.setOnClickListener { onRatingChanged(4, binding.star4) }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun onRatingChanged(rating: Int, selectedEmoji: ImageView) {
        this.selectedEmoji?.let { it.setBackgroundResource(R.drawable.circle_black_stroke_shape)}
        // Set the background of the selected emoji to the circle drawable
        selectedEmoji.setBackgroundResource(R.drawable.circle_white_stroke_shape)
        this.selectedEmoji = selectedEmoji
        this.selectedText = getEmojiText(rating)
    }

    private fun getEmojiText(emoji: Int): String {
        return when (emoji) {
            1 -> "Sad"
            2 -> "Not Happy"
            3 -> "Happy"
            4 -> "Very Happy"
            else -> "Happy"
        }
    }

    private fun getSelectedEmoji(): Int? {
        return when (selectedEmoji) {
            binding.star1 -> 1
            binding.star2 -> 2
            binding.star3 -> 3
            binding.star4 -> 4
            else -> null
        }
    }

    private fun getEmojiImageView(emoji: Int): ImageView {
        return when (emoji) {
            1 -> binding.star1
            2 -> binding.star2
            3 -> binding.star3
            4 -> binding.star4
            else -> binding.star3
        }
    }
}