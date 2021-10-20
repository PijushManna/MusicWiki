package com.example.musicwiki.ui.artists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.musicwiki.MainViewModel
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
        mainViewModel.currentArtist?.let {
            viewModel.fetchArtistsInfo(it)
            viewModel.fetchTopAlbums(it)
            viewModel.fetchTopTracks(it)
        }
        val adapter = ArtistsTagsAdapter(mainViewModel)
        val artistTopAlbums = ArtistTopAlbumsAdapter(mainViewModel)
        val artistsTopTracks = ArtistTopTracksAdapter(mainViewModel)

        binding.listAlbumTags.adapter = adapter
        binding.rcrArtistTopAlbums.adapter = artistTopAlbums
        binding.rcrArtistTopTracks.adapter = artistsTopTracks
        viewModel.artistInfo.observe(viewLifecycleOwner,{
            binding.model = it
            adapter.submitList(it.artist.tags.tag)
        })

        viewModel.artistTopAlbums.observe(viewLifecycleOwner,{
            it?.topalbums?.album?.let {album ->
                artistTopAlbums.submitList(album)
            }
        })

        viewModel.artistTopTracks.observe(viewLifecycleOwner,{
            it?.toptracks?.track?.let { tracks ->
                artistsTopTracks.submitList(tracks)
            }
        })

        return binding.root
    }

}