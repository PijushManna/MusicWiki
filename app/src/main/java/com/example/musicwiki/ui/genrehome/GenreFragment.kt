package com.example.musicwiki.ui.genrehome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicwiki.adapters.GenrePagesAdapter
import com.example.musicwiki.databinding.FragmentGenreBinding
import com.example.musicwiki.models.GenreType

class GenreFragment : Fragment() {

    private val binding: FragmentGenreBinding by lazy {
        FragmentGenreBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val fragments: ArrayList<Pair<Fragment, GenreType>> by lazy {
        arrayListOf(
            Pair(AlbumPagerFragment(), GenreType.ALBUMS),
            Pair(ArtistPagerFragment(), GenreType.ARTISTS),
            Pair(TracksPagerFragment(), GenreType.TRACKS)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            tabPages.setupWithViewPager(pgrTabs)
            pgrTabs.adapter = GenrePagesAdapter(requireActivity().supportFragmentManager, fragments)
        }
        return binding.root
    }

}