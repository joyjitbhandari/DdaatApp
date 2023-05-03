package com.example.ddaatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.UpcomingSessionAdapter
import com.example.ddaatapp.databinding.FragmentHomeSessionsBinding
import com.example.ddaatapp.datamodel.UpcomingSessionDataModel

class HomeSessionsFragment : Fragment() {
    private lateinit var binding: FragmentHomeSessionsBinding
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
        binding = FragmentHomeSessionsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val upcommingSessionList  = arrayListOf<UpcomingSessionDataModel>(
            UpcomingSessionDataModel(R.drawable.session_sample1,"John Smith","Video session","15 Dec 2023"),
            UpcomingSessionDataModel(R.drawable.session_sample2,"John Smith","Video session","15 Dec 2023"),
            UpcomingSessionDataModel(R.drawable.session_sample3,"John Smith","Video session","15 Dec 2023"),
            UpcomingSessionDataModel(R.drawable.session_sample4,"John Smith","Video session","15 Dec 2023"),
            UpcomingSessionDataModel(R.drawable.session_sample3,"John Smith","Video session","15 Dec 2023"),
            UpcomingSessionDataModel(R.drawable.session_sample2,"John Smith","Video session","15 Dec 2023"),
        )

//        adapter setting to recycler view
        val sessionRecyclerView = binding.sessionsRecycler
        val sessionAdapter = UpcomingSessionAdapter(upcommingSessionList,6)
        sessionRecyclerView.adapter = sessionAdapter


    }


    companion object {

        fun newInstance() = HomeSessionsFragment()
    }
}