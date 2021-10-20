package com.example.musicwiki.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.databinding.LayoutArtistTopTracksBinding
import com.example.musicwiki.repo.network.artiststoptracks.Track
import com.example.musicwiki.ui.setImage

class ArtistTopTracksAdapter(private val viewModel: MainViewModel) : ListAdapter<Track, ArtistTopTracksAdapter.ViewHolder>(ArtistTopTracksDiffUtilCallBack()) {
    class ViewHolder(private val binding: LayoutArtistTopTracksBinding,viewModel: MainViewModel):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Track){
            binding.txtItemTitle.text = item.name
            binding.imgItemLogo.setImage(item.image[3].text)
            binding.txtArtistName.text = item.artist.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutArtistTopTracksBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ArtistTopTracksDiffUtilCallBack : DiffUtil.ItemCallback<Track>(){
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem == newItem
    }

}