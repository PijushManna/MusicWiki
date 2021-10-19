package com.example.musicwiki.ui.genrehome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.adapters.GenrePagesAdapter
import com.example.musicwiki.databinding.FragmentGenreBinding
import com.example.musicwiki.models.GenreType
import com.example.musicwiki.ui.albums.AlbumPagerFragment
import com.example.musicwiki.ui.artists.ArtistPagerFragment
import com.example.musicwiki.ui.tracks.TracksPagerFragment

class GenreFragment : Fragment() {

    private val binding: FragmentGenreBinding by lazy {
        FragmentGenreBinding.inflate(layoutInflater)
    }

    private val fragments: ArrayList<Pair<Fragment, GenreType>> by lazy {
        arrayListOf(
            Pair(AlbumPagerFragment(), GenreType.ALBUMS),
            Pair(ArtistPagerFragment(), GenreType.ARTISTS),
            Pair(TracksPagerFragment(), GenreType.TRACKS)
        )
    }

    private val viewModel:MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            model = viewModel
            tabPages.setupWithViewPager(pgrTabs)
            pgrTabs.adapter = GenrePagesAdapter(requireActivity().supportFragmentManager, fragments)
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
        return binding.root
    }

}