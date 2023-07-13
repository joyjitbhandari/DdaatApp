package com.example.ddaatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.StreamsAdapter
import com.example.ddaatapp.utils.DynamicInterestChipCreator
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.utils.ShowDialog
import com.example.ddaatapp.databinding.FragmentUnsubscribeHomeLiveStreamBinding
import com.example.ddaatapp.utils.Constants

class UnsubscribeHomeLiveStreamingFragment(private val operationFlow: String) : Fragment() {

    private lateinit var binding: FragmentUnsubscribeHomeLiveStreamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentUnsubscribeHomeLiveStreamBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(operationFlow){
            Constants.TAB->{
                binding.txtCategories.visibility = View.GONE
                binding.horizontalScrollView.visibility = View.GONE
                binding.txtLiveStream.visibility = View.GONE
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


        //Live Streaming setup
        val liveStreamingList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.StreamsDataModel>(
            com.example.ddaatapp.model.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image,
                "Stream Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image2,
                "Stream Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image,
                "Stream Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image2,
                "Stream Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            )

        val liveStreamingRecyclerView = binding.liveStreamingRecycler
        val videoAdapter = StreamsAdapter(liveStreamingList,4,false,requireContext())
        liveStreamingRecyclerView.adapter = videoAdapter
        //List item Decoration
        val stationSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        liveStreamingRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(stationSpacing))


    }

}