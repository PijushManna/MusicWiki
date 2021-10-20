package com.example.musicwiki.ui.tracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.databinding.FragmentAlbumTrackArtistBinding

class TracksPagerFragment : Fragment() {
    private val viewModel:MainViewModel by activityViewModels()
    private val binding: FragmentAlbumTrackArtistBinding by lazy {
        FragmentAlbumTrackArtistBinding.inflate(layoutInflater)
    }
    private val adapter = TracksAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lstItems.adapter = adapter
        }
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.topTracks.observe(viewLifecycleOwner,{
            adapter.submitList(it)
        })
        return binding.root
    }
}