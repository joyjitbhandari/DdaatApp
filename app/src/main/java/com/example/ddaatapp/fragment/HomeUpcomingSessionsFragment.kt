package com.example.ddaatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.UpcomingSessionAdapter
import com.example.ddaatapp.commonClass.GridListSpacingItemDecoration
import com.example.ddaatapp.databinding.FragmentHomeUpcomingSessionsBinding
import com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel

class HomeUpcomingSessionsFragment : Fragment() {
    private lateinit var binding: FragmentHomeUpcomingSessionsBinding
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
        binding = FragmentHomeUpcomingSessionsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val upcomingSessionList  = arrayListOf<com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel>(
            com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel(
                R.drawable.session_sample1,
                "John Smith",
                "Video session",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel(
                R.drawable.session_sample2,
                "John Smith",
                "Video session",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel(
                R.drawable.session_sample3,
                "John Smith",
                "Video session",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel(
                R.drawable.session_sample4,
                "John Smith",
                "Video session",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel(
                R.drawable.session_sample3,
                "John Smith",
                "Video session",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.responseDatamodel.UpcomingSessionDataModel(
                R.drawable.session_sample2,
                "John Smith",
                "Video session",
                "15 Dec 2023"
            ),
        )

//        adapter setting to recycler view
        val sessionRecyclerView = binding.sessionsRecycler
        val sessionAdapter = UpcomingSessionAdapter(upcomingSessionList,6,requireContext())
        sessionRecyclerView.adapter = sessionAdapter
        //spacing set for item
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        sessionRecyclerView.addItemDecoration(GridListSpacingItemDecoration(spacing))

    }


    companion object {
        fun newInstance() = HomeUpcomingSessionsFragment()
    }
}