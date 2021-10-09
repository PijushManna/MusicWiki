package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicwiki.R
import com.example.musicwiki.adapters.WelcomeGenreAdapter
import com.example.musicwiki.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private val binding: FragmentWelcomeBinding by lazy {
        FragmentWelcomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val items = arrayListOf("Rock 1","Rock 2","Rock 3","Rock 3","Rock 3","Rock 3","Rock 3","Rock 3","Rock 3")
        binding.apply {
            lstGenre.adapter = WelcomeGenreAdapter(requireContext(),R.layout.list_item_genre,items)
        }
        return binding.root
    }
}