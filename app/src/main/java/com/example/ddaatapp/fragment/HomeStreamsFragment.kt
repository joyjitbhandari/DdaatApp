package com.example.ddaatapp.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.StreamsAdapter
import com.example.ddaatapp.utils.DynamicInterestChipCreator
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.utils.ShowDialog
import com.example.ddaatapp.databinding.FragmentHomeStreamsBinding
import com.example.ddaatapp.`object`.Constants

class HomeStreamsFragment(private val operationFlow:String): Fragment()  {
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

        when(operationFlow){
            Constants.TAB->{
                binding.txtCategories.visibility = View.GONE
                binding.horizontalScrollView.visibility = View.GONE
                binding.txtDdaatStation.visibility = View.GONE
                binding.btnSelectGenres.visibility = View.GONE
            }
            Constants.HOME->{
                //Setup chips in chipGroup view
                DynamicInterestChipCreator(requireContext()).setupChip(binding.choiceChipGroup)

                //Select Genres button
                binding.btnSelectGenres.setOnClickListener {
                    ShowDialog(requireContext()).showSelectGenresDialog()
                }
            }
        }

        //DdaatStation setup
        val videoList = arrayListOf<com.example.ddaatapp.responseDatamodel.StreamsDataModel>(
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image,
                "Stream Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image2,
                "Stream Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
        )

        val ddaatStationRecycler = binding.ddaatStationRecycler
        val videoAdapter = StreamsAdapter(videoList,2,false,requireContext())
        ddaatStationRecycler.adapter = videoAdapter
        //List item Decoration
        val stationSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        ddaatStationRecycler.addItemDecoration(LinearListSpacingItemDecoration(stationSpacing))


        //Podcast Station Setup
        val podcastList = arrayListOf<com.example.ddaatapp.responseDatamodel.StreamsDataModel>(
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image,
                "Podcast Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image2,
                "Podcast Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image3,
                "Podcast Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
        )
        val podcastRecycler = binding.podcastStationRecycler
        val podcastAdapter = StreamsAdapter(podcastList,2,true,requireContext())
        podcastRecycler.adapter = podcastAdapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        podcastRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))

    }
}