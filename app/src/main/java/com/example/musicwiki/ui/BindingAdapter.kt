package com.example.musicwiki.ui

import android.widget.GridView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.adapters.AlbumsAdapter
import com.example.musicwiki.repo.local.albums.Albums
import com.example.musicwiki.ui.genrehome.WelcomeGenreAdapter
import com.example.musicwiki.repo.local.genre.Genre

@BindingAdapter("list")
fun GridView.setGrid(item: List<Genre>?){
    (adapter as WelcomeGenreAdapter).apply {
        clear()
        item?.forEach { it ->
            add(it.name)
        }
        notifyDataSetChanged()
    }
}
