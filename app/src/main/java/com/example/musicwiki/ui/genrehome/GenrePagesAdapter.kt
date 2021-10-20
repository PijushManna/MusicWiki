package com.example.musicwiki.ui.genrehome

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class GenrePagesAdapter(fragmentManager: FragmentManager,private val fragments:ArrayList<Pair<Fragment, String>>) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
       return fragments.size
    }

    override fun getItem(position: Int): Fragment {
       return fragments[position].first
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragments[position].second
    }
}