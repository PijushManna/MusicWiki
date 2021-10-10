package com.example.musicwiki.ui.tracks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicwiki.R

class TracksDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = TracksDetailsFragment()
    }

    private lateinit var viewModel: TracksDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tracks_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TracksDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}