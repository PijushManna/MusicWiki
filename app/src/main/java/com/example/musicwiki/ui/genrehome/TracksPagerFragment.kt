package com.example.musicwiki.ui.genrehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musicwiki.adapters.TracksAdapter
import com.example.musicwiki.databinding.FragmentAlbumTrackArtistBinding
import com.example.musicwiki.models.Tracks

class TracksPagerFragment : Fragment() {

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
        adapter.submitList(
            mutableListOf(
                Tracks(1,"3","1"),
                Tracks(2,"3","1"),
                Tracks(3,"3","1"),
                Tracks(4,"3","1"),
                Tracks(1,"3","1"),
                Tracks(1,"3","1"),
                Tracks(1,"3","1"),
                Tracks(1,"3","1"),
            )
        )
        adapter.notifyDataSetChanged()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}