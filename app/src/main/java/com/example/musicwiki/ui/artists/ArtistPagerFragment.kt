package com.example.musicwiki.ui.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicwiki.MainViewModel
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
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.topArtists.observe(viewLifecycleOwner,{
            adapter.submitList(it)
        })
        return binding.root
    }
}