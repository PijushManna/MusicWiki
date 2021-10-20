package com.example.musicwiki.ui.artists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.StringRequest
import com.example.musicwiki.repo.Repository
import com.example.musicwiki.repo.network.artistinfo.ArtistInfo
import com.example.musicwiki.repo.network.artiststopalbums.ArtistTopAlbums
import com.example.musicwiki.repo.network.artiststoptracks.ArtistTopTracks

class ArtistsDetailsFragmentViewModel : ViewModel() {
    private val _artistInfo = MutableLiveData<ArtistInfo>()
    val artistInfo: LiveData<ArtistInfo> = _artistInfo
    private val _artistTopAlbums = MutableLiveData<ArtistTopAlbums>()
    val artistTopAlbums: LiveData<ArtistTopAlbums> = _artistTopAlbums
    private val _artistTopTracks = MutableLiveData<ArtistTopTracks>()
    val artistTopTracks: LiveData<ArtistTopTracks> = _artistTopTracks
    private val TAG = "AlbumDetailsViewModel"

    fun fetchArtistsInfo(item: String) {
        val url = Repository.getArtistInfoUrl(item)
        val formatter = Repository.getFormatter()
        val req = StringRequest(url, {
            _artistInfo.value = formatter.fromJson(it, ArtistInfo::class.java)
        }) {
        }
        Repository.addToRequestQueue(req)
    }

    fun fetchTopAlbums(item: String){
        val url = Repository.getArtistsTopAlbumsUrl(item)
        val formatter = Repository.getFormatter()
        val req = StringRequest(url, {
            _artistTopAlbums.value = formatter.fromJson(it, ArtistTopAlbums::class.java)
        }) {
        }
        Repository.addToRequestQueue(req)
    }

    fun fetchTopTracks(item: String){
        val url = Repository.getArtistsTopTracksUrl(item)
        val formatter = Repository.getFormatter()
        val req = StringRequest(url, {
            _artistTopTracks.value = formatter.fromJson(it, ArtistTopTracks::class.java)
        }) {
        }
        Repository.addToRequestQueue(req)
    }
}