package com.example.musicwiki.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ListItemAlbumTracksArtistBinding
import com.example.musicwiki.repo.local.artists.Artists
import com.example.musicwiki.ui.setImage


class ArtistsAdapter(private val viewModel: MainViewModel) : ListAdapter<Artists, ArtistsAdapter.ViewHolder>(
    AlbumArtistsTracksDiffUtilCallback()
) {
    class ViewHolder(private val binding: ListItemAlbumTracksArtistBinding,private val viewModel: MainViewModel) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Artists){
           binding.txtItemTitle.text  = item.name
            binding.imgItemLogo.setImage(item.image)
            viewModel.currentArtist = item.name
            binding.root.setOnClickListener {
                it.findNavController().navigate(R.id.action_genreFragment_to_artistsDetailsFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemAlbumTracksArtistBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        class AlbumArtistsTracksDiffUtilCallback : DiffUtil.ItemCallback<Artists>(){
            override fun areItemsTheSame(oldItem: Artists, newItem: Artists): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Artists, newItem: Artists): Boolean {
                return oldItem == newItem
            }

        }
    }
}