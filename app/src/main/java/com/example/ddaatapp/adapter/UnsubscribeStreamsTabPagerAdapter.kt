package com.example.ddaatapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.ddaatapp.fragment.UnsubscribeHomeLiveStreamingFragment
import com.example.ddaatapp.fragment.HomeStreamsFragment
import com.example.ddaatapp.fragment.HomeUpcomingSessionsFragment
import com.example.ddaatapp.`object`.Constants

class UnsubscribeStreamsTabPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeStreamsFragment(Constants.TAB)
            1 -> UnsubscribeHomeLiveStreamingFragment(Constants.TAB)
            else -> HomeUpcomingSessionsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "DDAAT Station"
            1 -> "Live Streaming"
            else -> "DDAAT Station"
        }
    }
}
