package com.example.musicwiki.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ListItemGenreBinding
import com.example.musicwiki.repo.network.artistinfo.Tag

class ArtistsTagsAdapter(private val viewModel: MainViewModel) : ListAdapter<Tag, ArtistsTagsAdapter.ViewHolder>(TagDiffUtilCallback()){

    class ViewHolder(private val binding: ListItemGenreBinding, private val viewModel: MainViewModel):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Tag){
            binding.btnTag.text = item.name
            binding.btnTag.setOnClickListener {
                viewModel.fetchInfo(item.name)
                it.findNavController().navigate(R.id.action_artistsDetailsFragment_to_genreFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ListItemGenreBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TagDiffUtilCallback : DiffUtil.ItemCallback<Tag>(){
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem == newItem
    }

}