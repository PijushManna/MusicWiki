package com.example.musicwiki.ui.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.adapters.AlbumsAdapter
import com.example.musicwiki.databinding.FragmentAlbumTrackArtistBinding
import com.example.musicwiki.models.Albums

class AlbumPagerFragment : Fragment() {

    private val binding: FragmentAlbumTrackArtistBinding by lazy {
        FragmentAlbumTrackArtistBinding.inflate(layoutInflater)
    }
    private val adapter = AlbumsAdapter()
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
            )
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}