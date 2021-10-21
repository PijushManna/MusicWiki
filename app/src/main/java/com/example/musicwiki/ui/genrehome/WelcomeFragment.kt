package com.example.musicwiki.ui.genrehome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.MainActivity
import com.example.musicwiki.MainViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private val binding: FragmentWelcomeBinding by lazy {
        FragmentWelcomeBinding.inflate(layoutInflater)
    }
    private val navController by lazy {
        this.findNavController()
    }
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.lifecycleOwner = viewLifecycleOwner

        //Setup Views
        binding.apply {
            model = viewModel
            lstGenreShort.adapter = GenreAdapter(
                requireContext(),viewModel , arrayListOf()
            )
            lstGenreLong.adapter = GenreAdapter(
                requireContext(),viewModel, arrayListOf()
            )
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

        //Added Observers
        viewModel.changeDestination.observe(viewLifecycleOwner,{
            if (it) findNavController().navigate(R.id.action_welcomeFragment_to_genreFragment2)
        })

        findNavController().addOnDestinationChangedListener { _, _, _ ->
            viewModel.changeDestination.value = false
        }

        return binding.root
    }
}