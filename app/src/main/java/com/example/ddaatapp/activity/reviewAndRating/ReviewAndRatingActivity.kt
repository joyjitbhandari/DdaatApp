package com.example.ddaatapp.activity.reviewAndRating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.ReviewAndRatingAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityReviewAndRatingBinding

class ReviewAndRatingActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityReviewAndRatingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewAndRatingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ratingList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel>(
            com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel(
                R.drawable.live_course_sample_img,
                "Ellie Olsen",
                "15 Dec 2023 12:30 pm",
                4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the."
            ),
            com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel(
                R.drawable.live_course_sample_img,
                "Ellie Olsen",
                "15 Dec 2023 12:30 pm",
                4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the."
            ),
            com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel(
                R.drawable.live_course_sample_img,
                "Ellie Olsen",
                "15 Dec 2023 12:30 pm",
                4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the."
            ),
            com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel(
                R.drawable.live_course_sample_img,
                "Ellie Olsen",
                "15 Dec 2023 12:30 pm",
                4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the."
            ),
            com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel(
                R.drawable.live_course_sample_img,
                "Ellie Olsen",
                "15 Dec 2023 12:30 pm",
                4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the."
            ),
            com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel(
                R.drawable.live_course_sample_img,
                "Ellie Olsen",
                "15 Dec 2023 12:30 pm",
                4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the."
            ),
            com.example.ddaatapp.model.responseDatamodel.ReviewAndRatingDataModel(
                R.drawable.live_course_sample_img,
                "Ellie Olsen",
                "15 Dec 2023 12:30 pm",
                4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the."
            ),

        )

        val reviewRecyclerView = binding.reviewRecycler
        val adapter = ReviewAndRatingAdapter(ratingList,this)
        reviewRecyclerView.adapter = adapter

        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        reviewRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
        }
    }
}