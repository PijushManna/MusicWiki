package com.example.musicwiki.ui.artists

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.StringRequest
import com.example.musicwiki.repo.Repository
import com.example.musicwiki.repo.local.albums.Albums
import com.example.musicwiki.repo.local.artists.Artists
import com.example.musicwiki.repo.network.albumsinfo.Album
import com.example.musicwiki.repo.network.albumsinfo.AlbumsInfo
import com.example.musicwiki.repo.network.artistinfo.ArtistInfo

class ArtistsDetailsFragmentViewModel : ViewModel() {
    private val _albumInfo = MutableLiveData<ArtistInfo>()
    val artistInfo: LiveData<ArtistInfo> = _albumInfo
    private val TAG = "AlbumDetailsViewModel"

    fun fetchArtistsInfo(item: String) {
        val url = Repository.getArtistInfoUrl(item)
        val formatter = Repository.getFormatter()
        val req = StringRequest(url, {
            _albumInfo.value = formatter.fromJson(it, ArtistInfo::class.java)
        }) {
        }
        Repository.addToRequestQueue(req)
    }
}