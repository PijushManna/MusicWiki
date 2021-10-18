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
import com.example.musicwiki.repo.network.genreinfo.TagInfo
import com.example.musicwiki.repo.network.topgenre.TopTagInfo
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Repository {
    private const val TAG = "REPOSITORY"
    private const val BASE_URL = "http://ws.audioscrobbler.com/2.0/"
    private const val API_KEY = "8bfe4bd8ae71bd4dda4b58cc138e1035"
    private const val FORMAT = "json"
    private lateinit var genreDatabase: GenreDAO
    private lateinit var requestQueue: RequestQueue
    private val gson = GsonBuilder().create()

    //Genre Variables
    private var offset = 0

    fun init(context: Context) {
        genreDatabase = GenreDatabase.getInstance(context).genreDAO
        requestQueue = Volley.newRequestQueue(context)
        CoroutineScope(Dispatchers.Default).launch {
            genreDatabase.getCount().apply {
                if (this == 0) {
                    fetchGenreFromNetwork()
                }
            }
        }
    }

    private fun fetchGenreFromNetwork() {
        val url = "$BASE_URL?method=tag.getTopTags&api_key=$API_KEY&format=$FORMAT&offset=$offset"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, TopTagInfo::class.java)
                res.toptags.tag.toSet().forEach {
                    if (it.name != null) {
                        genreDatabase.insert(
                            Genre(
                                name = it.name!!,
                                count = it.count,
                                reach = it.reach
                            )
                        )
                    }
                }
            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
        offset += 50
    }

    fun fetchGenreInfo(item:Genre):LiveData<Genre>{
        val url = "$BASE_URL?method=tag.getinfo&tag=${item.name}&api_key=$API_KEY&format=$FORMAT"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, TagInfo::class.java)
                item.content = res.tag?.wiki?.content
                item.summery = res.tag?.wiki?.summary
                genreDatabase.update(item)
            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
        return genreDatabase.getItemById(item.id)
    }

    fun getShortGenre(): LiveData<List<Genre>> {
        return genreDatabase.getData(10)
    }

    fun getAllGenre(): LiveData<List<Genre>> {
        return genreDatabase.getAllData()
    }
}