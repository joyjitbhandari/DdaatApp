package com.example.ddaatapp.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.VideoLibraryAdapter
import com.example.ddaatapp.utils.DynamicInterestChipCreator
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.FragmentHomeVideoLibraryBinding

class HomeVideoLibraryFragment(private val operationFlow:String) : Fragment() {
    private lateinit var binding: FragmentHomeVideoLibraryBinding
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
        binding = FragmentHomeVideoLibraryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Setup chips in chipGroup view
        DynamicInterestChipCreator(requireContext()).setupChip(binding.choiceChipGroup)


        //video list
        val videoList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image2,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image3,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image3,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            )

        val videoRecyclerView = binding.videoRecyclerView
        val adapter = VideoLibraryAdapter(videoList,5,requireContext(), operationFlow)
        videoRecyclerView.adapter = adapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        videoRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
    }
}