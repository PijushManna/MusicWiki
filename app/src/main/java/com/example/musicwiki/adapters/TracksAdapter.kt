package com.example.musicwiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ListItemAlbumTracksArtistBinding
import com.example.musicwiki.models.Tracks

class TracksAdapter : ListAdapter<Tracks, TracksAdapter.ViewHolder>(AlbumArtistsTracksDiffUtilCallback()) {
    class ViewHolder(private val binding: ListItemAlbumTracksArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tracks){
            binding.textView3.text = item.title
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