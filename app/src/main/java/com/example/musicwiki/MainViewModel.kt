package com.example.musicwiki

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.musicwiki.repo.Repository
import com.example.musicwiki.repo.local.albums.Albums
import com.example.musicwiki.repo.local.genre.Genre
import com.example.musicwiki.repo.network.topalbums.Album
import com.example.musicwiki.repo.network.topalbums.TopAlbums


class MainViewModel(application: Application) : AndroidViewModel(application){
    val shortGenre:LiveData<List<Genre>>
    val allGenre:LiveData<List<Genre>>
    lateinit var selectedTag:LiveData<Genre>
    lateinit var topAlbums: LiveData<List<Albums>>
    val changeDestination = MutableLiveData<Boolean>()
    val repository = Repository

    init {
        Repository.init(application.applicationContext)
        shortGenre = Repository.getShortGenre()
        allGenre = Repository.getAllGenre()
    }

    fun fetchInfo(item:Genre){
        if (item.name.isNotBlank()) {
            selectedTag = Repository.fetchGenreInfo(item)
            loadTopAlbums(item.name)
            topAlbums = Repository.getAllAlbums()
        }
    }

    private fun loadTopAlbums(q:String){
        Repository.checkAlbumsExistsForTheTag(tag = q)
    }
}