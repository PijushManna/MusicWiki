package com.example.musicwiki.ui.artists

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicwiki.R

class ArtistsDetailsragment : Fragment() {

    companion object {
        fun newInstance() = ArtistsDetailsragment()
    }

    private lateinit var viewModel: ArtistsDetailsragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.artists_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArtistsDetailsragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}