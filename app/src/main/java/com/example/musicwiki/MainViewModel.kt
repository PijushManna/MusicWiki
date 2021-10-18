package com.example.musicwiki

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.musicwiki.repo.Repository
import com.example.musicwiki.repo.local.genre.Genre


class MainViewModel(application: Application) : AndroidViewModel(application){
    val shortGenre:LiveData<List<Genre>>
    val allGenre:LiveData<List<Genre>>
    lateinit var selectedGenre:LiveData<Genre>
    val changeDestination = MutableLiveData<Boolean>()

    init {
        Repository.init(application.applicationContext)
        shortGenre = Repository.getShortGenre()
        allGenre = Repository.getAllGenre()
    }

    fun fetchInfo(item:Genre){
        selectedGenre = Repository.fetchGenreInfo(item)
    }
}