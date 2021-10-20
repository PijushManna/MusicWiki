package com.example.musicwiki.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.databinding.LayoutArtistsTopAlbumsBinding
import com.example.musicwiki.repo.network.artiststopalbums.Album
import com.example.musicwiki.ui.setImage

class ArtistTopAlbumsAdapter(private val viewModel: MainViewModel) : ListAdapter<Album, ArtistTopAlbumsAdapter.ViewHolder>(ArtistTopAlbumsDiffUtilCallBack()) {
    class ViewHolder(private val binding: LayoutArtistsTopAlbumsBinding,viewModel: MainViewModel):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Album){
            binding.txtItemTitle.text = item.name
            binding.imgItemLogo.setImage(item.image[3].text)
            binding.txtArtistName.text = item.artist.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutArtistsTopAlbumsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ArtistTopAlbumsDiffUtilCallBack : DiffUtil.ItemCallback<Album>(){
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
       return oldItem == newItem
    }

}