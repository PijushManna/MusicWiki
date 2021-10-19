package com.example.musicwiki.ui.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.adapters.AlbumsAdapter
import com.example.musicwiki.databinding.FragmentAlbumTrackArtistBinding
import com.example.musicwiki.models.Albums
import com.example.musicwiki.repo.Repository

class AlbumPagerFragment : Fragment() {

    private val binding: FragmentAlbumTrackArtistBinding by lazy {
        FragmentAlbumTrackArtistBinding.inflate(layoutInflater)
    }
    private val mainViewModel: MainViewModel by activityViewModels()
    private val adapter = AlbumsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lstItems.adapter = adapter
        }
        binding.lifecycleOwner = viewLifecycleOwner

        //Implement Recycler view
        mainViewModel.topAlbums.observe(viewLifecycleOwner, { it1 ->
            adapter.submitList(it1)
        })
        return binding.root
    }


}