package com.example.musicwiki.ui.genrehome

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ListItemGenreBinding

class WelcomeGenreAdapter(context: Context,private val viewModel: MainViewModel, items: ArrayList<String>) :
    ArrayAdapter<String>(context, 0, items) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ListItemGenreBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        binding.btnTag.text = getItem(position)
        binding.btnTag.setOnClickListener {
            viewModel.selectedGenre.value = viewModel.allGenre.value?.get(position)
            viewModel.changeDestination.value = true
        }
        return binding.root
    }
}