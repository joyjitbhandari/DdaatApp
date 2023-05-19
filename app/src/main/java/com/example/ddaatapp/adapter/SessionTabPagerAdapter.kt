package com.example.ddaatapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.ddaatapp.fragment.HomeUpcomingSessionsFragment
import com.example.ddaatapp.fragment.PastSessionFragment

class SessionTabPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeUpcomingSessionsFragment()
            1 -> PastSessionFragment()
            else -> HomeUpcomingSessionsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Upcoming Session"
            1 -> "Past Session"
            else -> "Upcoming Session"
        }
    }
}
