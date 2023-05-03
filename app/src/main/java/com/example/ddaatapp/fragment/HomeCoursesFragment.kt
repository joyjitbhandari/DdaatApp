package com.example.ddaatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.VideoLibraryAdapter
import com.example.ddaatapp.databinding.FragmentHomeCoursesBinding
import com.example.ddaatapp.datamodel.VideoLibraryDataModel

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
        val podcastList = arrayListOf<VideoLibraryDataModel>(
            VideoLibraryDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            VideoLibraryDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",false),
            VideoLibraryDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            VideoLibraryDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            VideoLibraryDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",false)
        )

        val courseRecycler = binding.courseRecycler
        val courseAdapter = VideoLibraryAdapter(podcastList,podcastList.size)
        courseRecycler.adapter = courseAdapter
    }


    companion object {
        fun newInstance() = HomeCoursesFragment()
    }
}