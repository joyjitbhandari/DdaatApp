package com.example.ddaatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.PastSessionAdapter
import com.example.ddaatapp.adapter.UpcomingSessionAdapter
import com.example.ddaatapp.commonClass.GridListSpacingItemDecoration
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.FragmentHomeUpcomingSessionsBinding
import com.example.ddaatapp.databinding.FragmentPastSessionBinding
import com.example.ddaatapp.datamodel.PastSessionDataModel
import com.example.ddaatapp.datamodel.UpcomingSessionDataModel

class PastSessionFragment : Fragment() {
    private lateinit var binding:FragmentPastSessionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPastSessionBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pastSessionList  = arrayListOf<PastSessionDataModel>(
            PastSessionDataModel(R.drawable.session_sample1,"John Smith","Video session"),
            PastSessionDataModel(R.drawable.session_sample2,"John Smith","Video session"),
            PastSessionDataModel(R.drawable.session_sample3,"John Smith","Video session"),
            PastSessionDataModel(R.drawable.session_sample4,"John Smith","Video session")
        )

//        adapter setting to recycler view
        val sessionRecyclerView = binding.pastSessionRecycler
        val sessionAdapter = PastSessionAdapter(pastSessionList,requireContext())
        sessionRecyclerView.adapter = sessionAdapter
        //spacing set for item
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        sessionRecyclerView.addItemDecoration(GridListSpacingItemDecoration(spacing))
    }
}