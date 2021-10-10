package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.R
import com.example.musicwiki.adapters.WelcomeGenreAdapter
import com.example.musicwiki.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private val binding: FragmentWelcomeBinding by lazy {
        FragmentWelcomeBinding.inflate(layoutInflater)
    }
    private val navController by lazy {
        this.findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val items = arrayListOf("Rock 1","Rock 2","Rock 3","Rock 3","Rock 3","Rock 3","Rock 3","Rock 3","Rock 3")
        binding.apply {
            lstGenre.adapter = WelcomeGenreAdapter(requireContext(),R.layout.list_item_genre,items)
            button2.setOnClickListener {
               navController.navigate(R.id.action_welcomeFragment_to_genreFragment2)
            }
        }

        return binding.root
    }
}