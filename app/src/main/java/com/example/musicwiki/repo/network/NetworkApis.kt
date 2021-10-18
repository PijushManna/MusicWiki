//package com.example.musicwiki.repo.network
//
//
//import android.content.Context
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Transformations
//import com.android.volley.RequestQueue
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.example.musicwiki.models.genre.Genre
//import com.example.musicwiki.models.genre.NetworkGenre
//import com.example.musicwiki.models.genre.Tag
//import com.google.gson.GsonBuilder
//
//private const val BASE_URL = "http://ws.audioscrobbler.com/2.0/"
//private const val apiKey = "8bfe4bd8ae71bd4dda4b58cc138e1035"
//private const val format ="json"
//
//
//object NetworkApis{
//    private val gson = GsonBuilder().create()
//    private val _genre =  MutableLiveData<List<Tag>>()
//    val genre:LiveData<List<Tag>> = _genre
//    private lateinit var requestQueue:RequestQueue
//    private var offset = 0
//
//
//}