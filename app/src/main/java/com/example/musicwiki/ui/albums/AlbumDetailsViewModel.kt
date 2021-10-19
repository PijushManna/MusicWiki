package com.example.musicwiki.ui.albums

import androidx.lifecycle.ViewModel
import com.example.musicwiki.repo.Repository

class AlbumDetailsViewModel : ViewModel() {
    val allData = Repository.getAllAlbums()
    init {

    }
}