package com.example.ddaatapp.fragment

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.StreamsAdapter
import com.example.ddaatapp.adapter.VideoLibraryAdapter
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.DialogSelectGenresBinding
import com.example.ddaatapp.databinding.FragmentHomeStreamsBinding
import com.example.ddaatapp.databinding.InterestChoiceChipItemBinding
import com.example.ddaatapp.datamodel.StreamsDataModel
import com.example.ddaatapp.datamodel.VideoLibraryDataModel
import com.google.android.material.chip.Chip

class HomeStreamsFragment : Fragment()  {
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
        val videoList = arrayListOf<StreamsDataModel>(
            StreamsDataModel(R.drawable.video_sample_image,"Stream Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            StreamsDataModel(R.drawable.video_sample_image2,"Stream Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
        )

        val ddaatStationRecycler = binding.ddaatStationRecycler
        val videoAdapter = StreamsAdapter(videoList,2)
        ddaatStationRecycler.adapter = videoAdapter
        //List item Decoration
        val stationSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        ddaatStationRecycler.addItemDecoration(LinearListSpacingItemDecoration(stationSpacing))





        //Podcast Station Setup
        val podcastList = arrayListOf<StreamsDataModel>(
            StreamsDataModel(R.drawable.video_sample_image,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            StreamsDataModel(R.drawable.video_sample_image2,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            StreamsDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
        )
        val podcastRecycler = binding.podcastStationRecycler
        val podcastAdapter = StreamsAdapter(podcastList,2)
        podcastRecycler.adapter = podcastAdapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        podcastRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))

        //Select Genres button
        binding.btnSelectGenres.setOnClickListener {
            ShowDialog(requireContext()).showSelectGenresDialog()
        }

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