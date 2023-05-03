package com.example.ddaatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.VideoLibraryAdapter
import com.example.ddaatapp.databinding.FragmentHomeStreamsBinding
import com.example.ddaatapp.databinding.InterestChoiceChipItemBinding
import com.example.ddaatapp.datamodel.VideoLibraryDataModel
import com.google.android.material.chip.Chip

class HomeStreamsFragment : Fragment() {

    private lateinit var binding: FragmentHomeStreamsBinding
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
        binding = FragmentHomeStreamsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Setup chips in chipGroup view
        setupChip()

        //DdaatStation setup
        val videoList = arrayListOf<VideoLibraryDataModel>(
            VideoLibraryDataModel(R.drawable.video_sample_image,"Stream Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            VideoLibraryDataModel(R.drawable.video_sample_image2,"Stream Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
        )

        val ddaatRecycler = binding.ddaatStationRecycler
        val videoAdapter = VideoLibraryAdapter(videoList,2)
        ddaatRecycler.adapter = videoAdapter

        //Podcast Station Setup
        val podcastList = arrayListOf<VideoLibraryDataModel>(
            VideoLibraryDataModel(R.drawable.video_sample_image,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            VideoLibraryDataModel(R.drawable.video_sample_image2,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
            VideoLibraryDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",null),
        )

        val podcastRecycler = binding.podcastStationRecycler
        val podcastAdapter = VideoLibraryAdapter(podcastList,2)
       podcastRecycler.adapter = podcastAdapter
    }

    companion object {
        fun newInstance() = HomeStreamsFragment()
    }



    private fun setupChip() {
        val interestList =
            arrayListOf(
                "Need Motivation",
                "Fitness",
                "Business",
                "Job",
                "Relationship",
                "Feeling Lonely",
                "Careers")
        for (name in interestList) {
            val chip = createChip(name)
            binding.choiceChipGroup.addView(chip)
        }
    }

    private fun createChip(label: String): Chip {
        val chip = InterestChoiceChipItemBinding.inflate(layoutInflater).root
        chip.text = label

        //setting padding
        val padding1 = resources.getDimension(R.dimen._20dp).toInt()
        val padding2 = resources.getDimension(R.dimen._18dp).toInt()
        chip.setPadding(padding1, padding2, padding1, padding2)
        return chip
    }
}