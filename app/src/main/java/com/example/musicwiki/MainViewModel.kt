package com.example.musicwiki

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.repo.Repository
import com.example.musicwiki.repo.local.albums.Albums
import com.example.musicwiki.repo.local.artists.Artists
import com.example.musicwiki.repo.local.genre.Genre
import com.example.musicwiki.repo.local.tracks.Tracks
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application){
    val shortGenre:LiveData<List<Genre>>
    val allGenre:LiveData<List<Genre>>
    lateinit var selectedGenre:LiveData<Genre>
    lateinit var topAlbums: LiveData<List<Albums>>
    lateinit var topArtists: LiveData<List<Artists>>
    lateinit var topTracks: LiveData<List<Tracks>>
    val changeDestination = MutableLiveData<Boolean>()
    var currentTag:String? = null
    var currentAlbum:Albums? = null
    var currentArtist:String? = null

    init {
        Repository.init(application.applicationContext)
        shortGenre = Repository.getShortGenre()
        allGenre = Repository.getAllGenre()
    }

    fun fetchInfo(name:String?){
        viewModelScope.launch {
            name?.let {
                currentTag = it
                selectedGenre = Repository.fetchGenre(it)
                topAlbums = Repository.fetchAlbums(it)
                topArtists = Repository.fetchArtists(it)
                topTracks = Repository.fetchTracks(it)
            }
        }
    }
}