package com.example.musicwiki.ui.albums

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.musicwiki.repo.Repository
import com.example.musicwiki.repo.local.albums.Albums
import com.example.musicwiki.repo.network.albumsinfo.Album
import com.example.musicwiki.repo.network.albumsinfo.AlbumsInfo

class AlbumsDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _albumInfo = MutableLiveData<Album>()
    val albumInfo: LiveData<Album> = _albumInfo
    private val TAG = "AlbumDetailsViewModel"

    fun fetchAlbumInfo(item: Albums) {
        val url = Repository.getAlbumInfoUrl(item)
        val formatter = Repository.getFormatter()
        val req = StringRequest(url, {
            _albumInfo.value = formatter.fromJson(it, AlbumsInfo::class.java).album
        }) {
            Log.e(TAG, it.message.toString())
        }
       Repository.addToRequestQueue(req)
    }
}