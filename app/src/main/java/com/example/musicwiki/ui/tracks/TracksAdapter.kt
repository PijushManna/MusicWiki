package com.example.musicwiki.ui.tracks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.databinding.ListItemAlbumTracksArtistBinding
import com.example.musicwiki.repo.local.tracks.Tracks
import com.example.musicwiki.ui.setImage

class TracksAdapter : ListAdapter<Tracks, TracksAdapter.ViewHolder>(
    AlbumArtistsTracksDiffUtilCallback()
) {
    class ViewHolder(private val binding: ListItemAlbumTracksArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tracks){
            binding.txtItemTitle.text = item.name
            binding.imgItemLogo.setImage(item.image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemAlbumTracksArtistBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        class AlbumArtistsTracksDiffUtilCallback : DiffUtil.ItemCallback<Tracks>(){
            override fun areItemsTheSame(oldItem: Tracks, newItem: Tracks): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Tracks, newItem: Tracks): Boolean {
                return oldItem == newItem
            }

        }
    }
}