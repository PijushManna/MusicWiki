package com.example.musicwiki.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.musicwiki.repo.local.genre.Genre
import com.example.musicwiki.repo.local.genre.GenreDAO
import com.example.musicwiki.repo.local.genre.GenreDatabase
import com.example.musicwiki.repo.network.genre.NetworkGenre
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Repository {
    private const val TAG = "REPOSITORY"
    private const val BASE_URL = "http://ws.audioscrobbler.com/2.0/"
    private const val apiKey = "8bfe4bd8ae71bd4dda4b58cc138e1035"
    private const val format ="json"
    private lateinit var genreDatabase: GenreDAO
    private lateinit var requestQueue: RequestQueue
    private val gson = GsonBuilder().create()

    //Genre Variables
    private var offset = 0

    fun init(context: Context){
        genreDatabase = GenreDatabase.getInstance(context).genreDAO
        requestQueue = Volley.newRequestQueue(context)
    }

    fun fetchGenreFromNetwork(){
        val url = "$BASE_URL?method=tag.getTopTags&api_key=$apiKey&format=$format&offset=$offset"
        val request = StringRequest(url,{ it ->
            CoroutineScope(Dispatchers.IO).launch {
            val res = gson.fromJson(it, NetworkGenre::class.java)
                res.toptags.tag.forEach {
                    genreDatabase.insert(Genre(name = it.name,count = it.count,reach = it.reach))
                }
            }
            },{
                Log.e(TAG,it.localizedMessage!!)
            })
        requestQueue.add(request)
        offset += 50
    }

    fun getGenre(lim:Int): LiveData<List<Genre>> {
        return genreDatabase.getData(lim)
    }
    //    fun loadTag(){
//        val url = "$BASE_URL?method=tag.getTopTags&api_key=$apiKey&format=$format&offset=$offset"
//        val request = StringRequest(url,{ it ->
//            val res = gson.fromJson(it,NetworkGenre::class.java)
//            _genre.value = res.toptags.tag.toList()
//            },{
//                Log.e("NetworkApis",it.localizedMessage!!)
//            })
//        requestQueue.add(request)
//
//    }
//
//    fun init(context: Context){
//        requestQueue = Volley.newRequestQueue(context)
//    }

}