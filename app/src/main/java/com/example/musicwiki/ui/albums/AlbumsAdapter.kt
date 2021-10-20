package com.example.musicwiki.ui.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ListItemAlbumTracksArtistBinding
import com.example.musicwiki.repo.local.albums.Albums

class AlbumsAdapter : ListAdapter<Albums, AlbumsAdapter.ViewHolder>(AlbumsDiffUtilCallback()) {
    class ViewHolder(private val binding: ListItemAlbumTracksArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item:Albums){
                binding.textView3.text = item.name
                Glide.with(binding.root.context).load(item.image).into(binding.imageView)
                binding.root.setOnClickListener {
                    it.findNavController().navigate(R.id.albumDetailsFragment)
                }
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
        class AlbumsDiffUtilCallback : DiffUtil.ItemCallback<Albums>(){
            override fun areItemsTheSame(oldItem: Albums, newItem: Albums): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Albums, newItem: Albums): Boolean {
                return oldItem == newItem
            }
        }
    }
}