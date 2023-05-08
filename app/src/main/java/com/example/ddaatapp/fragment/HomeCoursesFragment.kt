package com.example.ddaatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.MyPurchaseCourseAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.FragmentHomeCoursesBinding
import com.example.ddaatapp.datamodel.MyPurchaseCourseDataModel

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
        val  purchaseList = arrayListOf<MyPurchaseCourseDataModel>(
            MyPurchaseCourseDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",false),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            MyPurchaseCourseDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",false)
        )

        val courseRecycler = binding.courseRecycler
        val courseAdapter = MyPurchaseCourseAdapter(purchaseList,5)
        courseRecycler.adapter = courseAdapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        courseRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))
    }


    companion object {
        fun newInstance() = HomeCoursesFragment()
    }
}