package com.example.musicwiki.ui.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.adapters.ArtistsAdapter
import com.example.musicwiki.databinding.FragmentAlbumTrackArtistBinding

class ArtistPagerFragment : Fragment() {

    private val binding: FragmentAlbumTrackArtistBinding by lazy {
        FragmentAlbumTrackArtistBinding.inflate(layoutInflater)
    }
    private val adapter = ArtistsAdapter()
    private val viewModel:MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lstItems.adapter = adapter
        }
        adapter.submitList(
            mutableListOf(
//                Artists(1,"2","1"),
//                Artists(2,"2","1"),
//                Artists(3,"2","1"),
//                Artists(4,"2","1"),
//                Artists(1,"2","1"),
//                Artists(1,"2","1"),
//                Artists(1,"2","1"),
//                Artists(1,"2","1"),
            )
        )
        adapter.notifyDataSetChanged()
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}