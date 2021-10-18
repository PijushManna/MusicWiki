package com.example.musicwiki.ui.genrehome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import android.widget.Toast
=======
>>>>>>> c3711175f4ff84df0808f56c51285c3be4dd09f8
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
<<<<<<< HEAD
        binding.lifecycleOwner = viewLifecycleOwner
        binding.apply {
            model = viewModel
            lstGenreShort.adapter = WelcomeGenreAdapter(requireContext(),R.layout.list_item_genre,
                arrayListOf())
            lstGenreLong.adapter = WelcomeGenreAdapter(requireContext(),R.layout.list_item_genre,
=======
        binding.lifecycleOwner = this
        binding.apply {
            model = viewModel
            lstGenre.adapter = WelcomeGenreAdapter(requireContext(),R.layout.list_item_genre,
>>>>>>> c3711175f4ff84df0808f56c51285c3be4dd09f8
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