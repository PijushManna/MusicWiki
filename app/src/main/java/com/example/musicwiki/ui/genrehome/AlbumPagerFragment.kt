package com.example.musicwiki.ui.genrehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musicwiki.adapters.AlbumsAdapter
import com.example.musicwiki.databinding.FragmentAlbumTrackArtistBinding
import com.example.musicwiki.models.Albums

class AlbumPagerFragment : Fragment() {

    private val binding: FragmentAlbumTrackArtistBinding by lazy {
        FragmentAlbumTrackArtistBinding.inflate(layoutInflater)
    }
    private val adapter = AlbumsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lstItems.adapter = adapter
        }
        adapter.submitList(
            mutableListOf(
                Albums(1,"1","1"),
                Albums(2,"1","1"),
                Albums(3,"1","1"),
                Albums(4,"1","1"),
                Albums(1,"1","1"),
                Albums(1,"1","1"),
                Albums(1,"1","1"),
                Albums(1,"1","1"),
            )
        )
        adapter.notifyDataSetChanged()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}