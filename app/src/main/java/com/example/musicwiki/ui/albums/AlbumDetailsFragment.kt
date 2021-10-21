package com.example.musicwiki.ui.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.databinding.AlbumDetailsFragmentBinding
import com.example.musicwiki.ui.genrehome.GenreAdapter
import com.example.musicwiki.ui.setImage

class AlbumDetailsFragment : Fragment() {

    private lateinit var binding:AlbumDetailsFragmentBinding
    private val mainViewModel:MainViewModel by activityViewModels()
    private val viewModel:AlbumsDetailsViewModel by lazy {
        AlbumsDetailsViewModel(application = requireActivity().application)
    }
    private lateinit var adapter: AlbumsTagsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AlbumDetailsFragmentBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        adapter = AlbumsTagsAdapter(mainViewModel)
        binding.listAlbumTags.adapter = adapter
        viewModel.albumInfo.observe(viewLifecycleOwner,{
            it?.let {
                binding.apply {
                    txtArtistInfo.text = it.artist
                    txtAlbumTitle.text = it.name
                    txtAlbumDescription.text = it.wiki?.content ?: "Not Found"
                    imgCover.setImage(it.image[3].text)
                    adapter.submitList(it.tags.tag)
                    imgBack.setOnClickListener {
                        findNavController().navigateUp()
                    }
                }
            }
        })
        mainViewModel.currentAlbum?.let {
            viewModel.fetchAlbumInfo(it)
        }
        return binding.root
    }
}