package com.example.musicwiki.ui

import android.widget.GridView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.musicwiki.ui.genrehome.GenreAdapter
import com.example.musicwiki.repo.local.genre.Genre

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
        Glide.with(this.context).load(it).into(this)
    }
}