package com.example.musicwiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ListItemAlbumTracksArtistBinding
import com.example.musicwiki.models.Artists


class ArtistsAdapter : ListAdapter<Artists, ArtistsAdapter.ViewHolder>(AlbumArtistsTracksDiffUtilCallback()) {
    class ViewHolder(private val binding: ListItemAlbumTracksArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Artists){
           //TODO TBI
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
        class AlbumArtistsTracksDiffUtilCallback : DiffUtil.ItemCallback<Artists>(){
            override fun areItemsTheSame(oldItem: Artists, newItem: Artists): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Artists, newItem: Artists): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }
}