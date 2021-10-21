package com.example.musicwiki.ui

import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
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
        if(it != "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png" || it!="https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png") {
            Glide.with(this.context)
                .load(it)
                .placeholder(R.drawable.loading)
                .into(this)
        }
    }
}

@BindingAdapter("set_count")
fun TextView.setCount(item: String?){
    item?.let{
        text = withSuffix(it.toLong())
    }
}

fun withSuffix(count: Long): String {
    if (count < 1000) return "" + count
    val exp = (Math.log(count.toDouble()) / Math.log(1000.0)).toInt()
    return String.format(
        "%.1f %c",
        count / Math.pow(1000.0, exp.toDouble()),
        "kMGTPE"[exp - 1]
    )
}

