package com.example.ddaatapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.superPower.SurveyActivity
import com.example.ddaatapp.adapter.CourseAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.FragmentHomeCoursesBinding

class HomeCoursesFragment : Fragment() {

    private lateinit var binding: FragmentHomeCoursesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeCoursesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setup course list
        val  courseList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.CourseDataModel>(
            com.example.ddaatapp.model.responseDatamodel.CourseDataModel(
                R.drawable.video_sample_image,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                true
            ),
            com.example.ddaatapp.model.responseDatamodel.CourseDataModel(
                R.drawable.video_sample_image2,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                false
            ),
            com.example.ddaatapp.model.responseDatamodel.CourseDataModel(
                R.drawable.video_sample_image3,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                true
            ),
            com.example.ddaatapp.model.responseDatamodel.CourseDataModel(
                R.drawable.video_sample_image3,
                "Course Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                true
            ),
            com.example.ddaatapp.model.responseDatamodel.CourseDataModel(
                R.drawable.video_sample_image3,
                "Podcast Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                false
            )
        )

        val courseRecycler = binding.courseRecycler
        val courseAdapter = CourseAdapter(courseList,5,requireContext())
        courseRecycler.adapter = courseAdapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        courseRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))

        binding.btnTakeSurvey.setOnClickListener {
            startActivity(Intent(requireContext(),SurveyActivity::class.java))
        }

    }


    companion object {
        fun newInstance() = HomeCoursesFragment()
    }
}