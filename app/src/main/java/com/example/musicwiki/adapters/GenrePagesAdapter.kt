package com.example.musicwiki.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.musicwiki.models.GenreType

class GenrePagesAdapter(fragmentManager: FragmentManager,private val fragments:ArrayList<Pair<Fragment, GenreType>>) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
       return fragments.size
    }

    override fun getItem(position: Int): Fragment {
       return fragments[position].first
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragments[position].second.toString()
    }
}