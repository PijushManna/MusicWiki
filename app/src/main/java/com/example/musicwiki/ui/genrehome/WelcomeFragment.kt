package com.example.musicwiki.ui.genrehome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.MainViewModel
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
    private val viewModel:MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.apply {
            model = viewModel
            lstGenreShort.adapter = WelcomeGenreAdapter(requireContext(),R.layout.list_item_genre,
                arrayListOf())
            lstGenreLong.adapter = WelcomeGenreAdapter(requireContext(),R.layout.list_item_genre,
                arrayListOf())
            button2.setOnClickListener {
               navController.navigate(R.id.action_welcomeFragment_to_genreFragment2)
            }
            btnToggleGenre.setOnCheckedChangeListener { _, b ->
                if(b){
                    lstGenreShort.visibility = View.GONE
                    lstGenreLong.visibility = View.VISIBLE
                }else{
                    lstGenreShort.visibility = View.VISIBLE
                    lstGenreLong.visibility = View.GONE
                }
            }
        }
        return binding.root
    }
}