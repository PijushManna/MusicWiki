package com.example.musicwiki

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.musicwiki.repo.Repository
import com.example.musicwiki.repo.local.genre.Genre


class MainViewModel(application: Application) : AndroidViewModel(application){
    val genre:LiveData<List<Genre>>
    init {
        Repository.init(application.applicationContext)
        genre = Repository.getGenre(10)
    }
    fun toggleItemsCount(){
    }
}