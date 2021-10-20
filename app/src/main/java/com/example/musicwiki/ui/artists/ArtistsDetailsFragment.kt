package com.example.musicwiki.ui.artists

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ArtistsDetailsFragmentBinding

class ArtistsDetailsFragment : Fragment() {
    private val mainViewModel:MainViewModel by activityViewModels()
    private val viewModel = ArtistsDetailsFragmentViewModel()
    private val binding:ArtistsDetailsFragmentBinding by lazy {
        ArtistsDetailsFragmentBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainViewModel.currentArtist?.let { viewModel.fetchArtistsInfo(it) }
        val adapter = ArtistsTagsAdapter(mainViewModel)
        binding.listAlbumTags.adapter = adapter
        viewModel.artistInfo.observe(viewLifecycleOwner,{
            binding.model = it
            adapter.submitList(it.artist.tags.tag)
        })
        return binding.root
    }

}