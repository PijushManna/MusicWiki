package com.example.musicwiki.ui

import android.widget.GridView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.ui.genrehome.GenreAdapter
import com.example.musicwiki.repo.local.genre.Genre
import com.example.musicwiki.repo.network.artistinfo.Tag
import com.example.musicwiki.ui.artists.ArtistsTagsAdapter

@BindingAdapter("list")
fun GridView.setGrid(item: List<Genre>?){
    (adapter as GenreAdapter).apply {
        clear()
        item?.forEach { it ->
            add(it.name)
        }
        notifyDataSetChanged()
    }
}

@BindingAdapter("set_image")
fun ImageView.setImage(item: String?){
    item?.let{
        Glide.with(this.context)
            .load(it)
            .placeholder(R.drawable.loading)
            .into(this)
    }
}
